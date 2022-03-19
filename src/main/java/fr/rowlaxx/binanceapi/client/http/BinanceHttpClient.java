package fr.rowlaxx.binanceapi.client.http;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import fr.rowlaxx.binanceapi.client.BinanceClientImpl;
import fr.rowlaxx.binanceapi.exceptions.BinanceAutoHttpRequestException;

public class BinanceHttpClient extends SimpleBinanceHttpClient {

	//Variables
	private final BaseEndpointResolver baseEndpointResolver = new BaseEndpointResolver();
	
	//Constructeurs
	public BinanceHttpClient(BinanceClientImpl api) {
		super(api);
	}

	//Methodes
	public final <T> T execute(ApiEndpoint endpoint, BinanceAutoHttpRequest request) throws IOException {
		return execute(endpoint, new Object[] {request} );
	}
	
	public final <T> T execute(ApiEndpoint endpoint, Object... params) throws IOException {
		//Verifying		
		Objects.requireNonNull(endpoint, "endpoint may not be null.");
		ApiEndpointUtils.verify(endpoint);

		if (params == null)
			params = new Object[] {};
		
		//Building request
		final BinanceHttpRequest.Builder builder = BinanceHttpRequest.newBuilder();
		builder.addSignature(endpoint.needSignature());
		builder.setEndpoint(endpoint.endpoint());
		builder.setMethod(endpoint.method());
		
		//Base endpoint
		if (endpoint.baseEndpoint() == BaseEndpoints.CUSTOM)
			builder.setBaseEndpoint( baseEndpointResolver.get(endpoint.customBaseEndpoint()) );
		else
			builder.setBaseEndpoint( baseEndpointResolver.get(endpoint.baseEndpoint()));
		
		//Parameters
		final boolean isAutoRequest = (params.length == 1) ? params[0] instanceof BinanceAutoHttpRequest : false;
		
		//Il s'agit d'une requete automatique
		Parameters parameter;
		Object value;
		
		if (isAutoRequest) {
			final Map<Parameters, Object> map = ((BinanceAutoHttpRequest)params[0]).getParametersValue();
			int index;
			
			//Pour chaque valeur dans l'objet
			for (Entry<Parameters, Object> entry : map.entrySet()) {
				parameter = entry.getKey();
				value = entry.getValue();
				
				//On cherche l'index du parametre
				index = -1;
				for (int i = 0 ; i < endpoint.parameters().length ; i++)
					if (endpoint.parameters()[i] == parameter) {
						index = i;
						break;
					}
				
				//Il s'agit d'un paramètre en trop
				if (index == -1)
					throw new BinanceAutoHttpRequestException("Unable to find the parameters " + parameter + " is the endpoint.");
				
				//Le paramètre est obligatoire
				if (endpoint.mandatory()[index] && value == null)
					throw new NullPointerException("Parameters " + parameter + " is mandatory but null.");
				
				builder.setParameter(parameter, value);
			}
		}
		else {
			int def = 0;
			for (int i = 0 ; i < endpoint.parameters().length ; i++) {
				parameter = endpoint.parameters()[i];
				
				if (endpoint.defaultValues().length != 0)
					if (!((String)(value = endpoint.defaultValues()[i])).isBlank() ) {
						builder.setParameter(parameter, value);
						def++;
						continue;
					}
				
				value = params[i-def];
				if (endpoint.mandatory()[i] && value == null)
					throw new NullPointerException("Parameters " + parameter + " is mandatory but null.");
				
				builder.setParameter(parameter, value);
			}
		}
				
		//Execution
		return execute(builder.build());
	}
}