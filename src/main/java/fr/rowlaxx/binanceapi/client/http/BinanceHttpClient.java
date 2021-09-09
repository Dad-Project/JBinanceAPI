package fr.rowlaxx.binanceapi.client.http;

import java.io.IOException;
import java.util.Objects;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public class BinanceHttpClient extends SimpleBinanceHttpClient {

	//Variables
	private final BaseEndpointResolver baseEndpointResolver = new BaseEndpointResolver();
	
	//Constructeurs
	public BinanceHttpClient(BinanceClient api) {
		super(api);
	}

	//Methodes
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
		Object value;
		Parameters parameter;
		for (int i = 0 ; i < params.length ; i++) {
			value = params[i];
			parameter = endpoint.parameters()[i];
			
			if (endpoint.mandatory()[i] && value == null)
				throw new NullPointerException("Parameters " + parameter + " is mandatory but null.");
			
			builder.setParameter(parameter, value);
		}

		//Execution
		final BinanceHttpRequest request = builder.build();
		return executeWithRetry(request, 5);
	}
}