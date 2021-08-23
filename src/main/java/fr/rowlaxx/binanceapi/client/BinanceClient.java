package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.account.BinanceBSwapClient;
import fr.rowlaxx.binanceapi.client.account.BinanceBlvtClient;
import fr.rowlaxx.binanceapi.client.account.BinanceCoinmClient;
import fr.rowlaxx.binanceapi.client.account.BinanceMarginClient;
import fr.rowlaxx.binanceapi.client.account.BinanceMasterAccount;
import fr.rowlaxx.binanceapi.client.account.BinanceMiningClient;
import fr.rowlaxx.binanceapi.client.account.BinanceOptionsClient;
import fr.rowlaxx.binanceapi.client.account.BinanceSavingsClient;
import fr.rowlaxx.binanceapi.client.account.BinanceSpotClient;
import fr.rowlaxx.binanceapi.client.account.BinanceUsdmClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClientException;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public class BinanceClient {
	
	//Methodes statiques
	public static BinanceClient createGuest() {
		return new BinanceClient();
	}
	
	public static BinanceClient create(final String apiKey, final String apiSecret) {
		return new BinanceClient(apiKey, apiSecret);
	}
	
	//Variables
	private final BinanceBlvtClient blvt;
	private final BinanceBSwapClient bswap;
	private final BinanceCoinmClient futurecoinm;
	private final BinanceMarginClient margin;
	private final BinanceMiningClient mining;
	private final BinanceOptionsClient options;
	private final BinanceSavingsClient savings;
	private final BinanceSpotClient spot;
	private final BinanceUsdmClient futureusdm;
	private final BinanceMasterAccount masterAccount;
	
	private final String apiKey, apiSecret;
	private Boolean logged = null;
	private final BinanceHttpClient httpClient;
			
	//Constructeurs
	private BinanceClient(String apiKey, String apiSecret) {
		if (apiKey == null && apiSecret == null) {
			this.apiKey = null;
			this.apiSecret = null;
			this.logged = false;
		}
		else {
			Objects.requireNonNull(apiKey, "apiKey may not be null.");
			Objects.requireNonNull(apiSecret, "apiSecret may not be null.");
			if (apiKey.length() != 64)
				throw new IllegalArgumentException("apiKey must be 64 characters long.");
			if (apiSecret.length() != 64)
				throw new IllegalArgumentException("apiSecret must be 64 characters long.");
			if (!apiKey.matches("[\\w]*") )
				throw new IllegalArgumentException("apiKey is in an incorect format.");
			if (!apiSecret.matches("[\\w]*"))
				throw new IllegalArgumentException("apiSecret is in an incorect format.");
				
			this.apiKey = apiKey;
			this.apiSecret = apiSecret;
		}
		
		this.httpClient = new BinanceHttpClient(this);
		
		this.blvt = BinanceClientImplementer.implementz(BinanceBlvtClient.class, this);
		this.bswap = BinanceClientImplementer.implementz(BinanceBSwapClient.class, this);
		this.futurecoinm = BinanceClientImplementer.implementz(BinanceCoinmClient.class, this);
		this.margin = BinanceClientImplementer.implementz(BinanceMarginClient.class, this);
		this.masterAccount = BinanceClientImplementer.implementz(BinanceMasterAccount.class, this);
		this.mining = BinanceClientImplementer.implementz(BinanceMiningClient.class, this);
		this.options = BinanceClientImplementer.implementz(BinanceOptionsClient.class, this);
		this.savings = BinanceClientImplementer.implementz(BinanceSavingsClient.class, this);
		this.spot = BinanceClientImplementer.implementz(BinanceSpotClient.class, this);
		this.futureusdm = BinanceClientImplementer.implementz(BinanceUsdmClient.class, this);
	}
	
	private BinanceClient() {
		this(null, null);
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
			}catch(Exception e) {
				this.logged = null;
				throw e;
			}
		}
	}
	
	public long getServerTime() throws IOException {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/api/v3/time", Method.GET)
				.addSignature(false)
				.build();
		final JSONObject response = httpClient.execute(request);
		return response.getLong("serverTime");
	}
	
	public boolean ping() {
		try {
			final BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/api/v3/ping", Method.GET)
					.addSignature(false)
					.build();
			httpClient.execute(request);
			return true;
		}catch(IOException e) {
			return false;
		}
	}
	
	//Account
	public BinanceBlvtClient blvt() {
		return this.blvt;
	}
	
	public BinanceBSwapClient bswap() {
		return bswap;
	}
	
	public BinanceCoinmClient futureCoinM() {
		return futurecoinm;
	}
	
	public BinanceUsdmClient futureUsdM() {
		return futureusdm;
	}
	
	public BinanceMarginClient margin() {
		return margin;
	}
	
	public BinanceMiningClient mining() {
		return mining;
	}
	
	public BinanceOptionsClient options() {
		return options;
	}
	
	public BinanceSavingsClient savings() {
		return savings;
	}
	
	public BinanceSpotClient spot() {
		return spot;
	}
	
	public BinanceMasterAccount masterAccount() {
		return masterAccount;
	}
	
	//Getter
	public String getApiKey() {
		return apiKey;
	}
	
	public BinanceHttpClient getHttpClient() {
		return httpClient;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}
	
	public boolean isGuest() {
		return this.apiKey == null || this.apiSecret == null;
	}
	
	public boolean isLogged() {
		if (isGuest())
			throw new BinanceAPIException("You cannot use this method on a guest client.");
		if (logged == null)
			throw new BinanceAPIException("Please use the method BinanceAPI.login() before calling this method.");
		return logged;
	}
}
