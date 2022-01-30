package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

import com.sun.tools.javac.util.DefinedBy.Api;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.api.spot.WalletAPI;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.exceptions.BinanceAPIException;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.utils.generic.ReflectionUtils;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public class BinanceClientImpl {
	
	//Methodes statiques
	public static BinanceClientImpl createGuest() {
		return new BinanceClientImpl(null);
	}
	
	public static BinanceClientImpl create(final String apiKey, final String apiSecret) {
		return new BinanceClientImpl(apiKey, apiSecret);
	}
	
	public static BinanceClientImpl create(final BinanceCredenticals credenticals) {
		Objects.requireNonNull(credenticals, "credenticals may not be null.");
		return new BinanceClientImpl(credenticals);
	}
	
	//Variables	
	private WalletAPI wallet;
	
	private Boolean logged = null;
	private final BinanceCredenticals credenticals;
	private final BinanceHttpClient httpClient;
			
	//Constructeurs
	private BinanceClientImpl(String apiKey, String apiSecret) {
		this(new BinanceCredenticals(apiKey, apiSecret));
	}
	
	@SuppressWarnings("unchecked")
	private BinanceClientImpl(BinanceCredenticals credenticals) {
		this.credenticals = credenticals;
		this.httpClient = new BinanceHttpClient(this);
				
		Api api;
		for (Field field : BinanceClientImpl.class.getDeclaredFields()) {
			if (!Api.class.isAssignableFrom(field.getType()))
				continue;
			
			api = ApiImplementer.implementz( (Class<? extends Api>)field.getType(), this);
			ReflectionUtils.trySet(field, this, api);
		}
	}
	
	//Méthodes
	public boolean login() throws IOException {
		if ( isGuest() )
			throw new BinanceAPIException("You cannot use this method as a guest.");
		if (logged != null)
			return logged;
		
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/sapi/v1/capital/deposit/address", Method.GET)
				.setParameter(Parameters.coin, "BTC")
				.setBaseEndpoint(BaseEndpoints.SPOT.getUrls().get(0))
				.build();
		
		synchronized (this) {
			try{
				this.logged = true;
				httpClient.execute(request);
				return true;
			}catch(BinanceHttpClientException e) {
				if (e.getCode() == -2008 || e.getCode() == -1022) {
					this.logged = false;
					return false;
				}
				this.logged = null;
				throw e;
			}
		}
	}
	
	//Getter
	public BinanceCredenticals getCredenticals() {
		return credenticals;
	}
	
	public BinanceHttpClient getHttpClient() {
		return httpClient;
	}
	
	public boolean isGuest() {
		return credenticals == null;
	}
	
	public boolean isLogged() {
		if (isGuest())
			throw new BinanceAPIException("You cannot use this method on a guest client.");
		if (logged == null)
			throw new BinanceAPIException("Please use the method BinanceClient.login() before calling this method.");
		return logged;
	}
	
	//Methodes
	public WalletAPI wallet() {
		return this.wallet;
	}
}
