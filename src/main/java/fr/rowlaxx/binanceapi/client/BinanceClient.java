package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.exceptions.BinanceAPIException;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.interfaces.api.coinm.CoinmAPI;
import fr.rowlaxx.binanceapi.interfaces.api.options.OptionsAPI;
import fr.rowlaxx.binanceapi.interfaces.api.spot.SpotAPI;
import fr.rowlaxx.binanceapi.interfaces.api.usdm.UsdmAPI;

public class BinanceClient {
	
	//Methodes statiques
	public static BinanceClient createGuest() {
		return new BinanceClient(null);
	}
	
	public static BinanceClient create(final String apiKey, final String apiSecret) {
		return new BinanceClient(apiKey, apiSecret);
	}
	
	//Variables	
	private final SpotAPI spot;
	private final UsdmAPI usdm;
	private final CoinmAPI coinm;
	private final OptionsAPI options;
	
	private Boolean logged = null;
	private final BinanceCredenticals credenticals;
	private final BinanceHttpClient httpClient;
			
	//Constructeurs
	private BinanceClient(String apiKey, String apiSecret) {
		this(new BinanceCredenticals(apiKey, apiSecret));
	}
	
	private BinanceClient(BinanceCredenticals credenticals) {
		this.credenticals = credenticals;
		this.httpClient = new BinanceHttpClient(this);
		
		this.spot = BinanceClientImplementer.implementz(SpotAPI.class, this);
		this.usdm = BinanceClientImplementer.implementz(UsdmAPI.class, this);
		this.coinm = BinanceClientImplementer.implementz(CoinmAPI.class, this);
		this.options = BinanceClientImplementer.implementz(OptionsAPI.class, this);
	}
	
	//Méthodes
	public boolean login() throws IOException {
		if ( isGuest() )
			throw new BinanceAPIException("You cannot use this method as a guest.");
		if (logged != null)
			return logged;
		
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/sapi/v1/capital/deposit/address", Method.GET)
				.setParameter(Parameters.coin, "BTC")
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
	public SpotAPI spot() {
		return spot;
	}
	
	public UsdmAPI usdM() {
		return usdm;
	}
	
	public CoinmAPI coinM() {
		return coinm;
	}
	
	public OptionsAPI options() {
		return options;
	}
}
