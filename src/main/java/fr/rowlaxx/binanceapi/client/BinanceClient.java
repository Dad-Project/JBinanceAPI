package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.util.Objects;

import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.exceptions.BinanceAPIException;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.interfaces.api.BLVTAPI;
import fr.rowlaxx.binanceapi.interfaces.api.BSwapAPI;
import fr.rowlaxx.binanceapi.interfaces.api.C2CAPI;
import fr.rowlaxx.binanceapi.interfaces.api.FiatAPI;
import fr.rowlaxx.binanceapi.interfaces.api.FuturesAPI;
import fr.rowlaxx.binanceapi.interfaces.api.MarginAPI;
import fr.rowlaxx.binanceapi.interfaces.api.MiningAPI;
import fr.rowlaxx.binanceapi.interfaces.api.SavingsAPI;
import fr.rowlaxx.binanceapi.interfaces.api.SubAccountAPI;
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
	
	public static BinanceClient create(final BinanceCredenticals credenticals) {
		Objects.requireNonNull(credenticals, "credenticals may not be null.");
		return new BinanceClient(credenticals);
	}
	
	//Variables	
	private final SpotAPI spot;
	private final SubAccountAPI subaccount;
	private final BLVTAPI blvt;
	private final UsdmAPI usdm;
	private final CoinmAPI coinm;
	private final OptionsAPI options;
	private final BSwapAPI bswap;
	private final C2CAPI c2c;
	private final FiatAPI fiat;
	private final FuturesAPI futures;
	private final MarginAPI margin;
	private final MiningAPI mining;
	private final SavingsAPI savings;
	
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
		this.subaccount = BinanceClientImplementer.implementz(SubAccountAPI.class, this);
		this.blvt = BinanceClientImplementer.implementz(BLVTAPI.class, this);
		this.usdm = BinanceClientImplementer.implementz(UsdmAPI.class, this);
		this.coinm = BinanceClientImplementer.implementz(CoinmAPI.class, this);
		this.options = BinanceClientImplementer.implementz(OptionsAPI.class, this);
		this.bswap = BinanceClientImplementer.implementz(BSwapAPI.class, this);
		this.c2c = BinanceClientImplementer.implementz(C2CAPI.class, this);
		this.fiat = BinanceClientImplementer.implementz(FiatAPI.class, this);
		this.futures = BinanceClientImplementer.implementz(FuturesAPI.class, this);
		this.margin = BinanceClientImplementer.implementz(MarginAPI.class, this);
		this.mining = BinanceClientImplementer.implementz(MiningAPI.class, this);
		this.savings = BinanceClientImplementer.implementz(SavingsAPI.class, this);
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
	public SpotAPI spot() {
		return spot;
	}
	
	public SubAccountAPI subaccount() {
		return subaccount;
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
	
	public BLVTAPI blvt() {
		return blvt;
	}
	
	public BSwapAPI bswap() {
		return bswap;
	}
	
	public C2CAPI c2c() {
		return c2c;
	}
	
	public MarginAPI margin() {
		return margin;
	}
	
	public MiningAPI mining() {
		return mining;
	}
	
	public SavingsAPI savings() {
		return savings;
	}
	
	public FiatAPI fiat() {
		return fiat;
	}
	
	public FuturesAPI futures() {
		return futures;
	}
}
