package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.lang.reflect.Field;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.api.coinm.CoinmAPI;
import fr.rowlaxx.binanceapi.api.coinm.CoinmMarketDataAPI;
import fr.rowlaxx.binanceapi.api.coinm.CoinmTradeAPI;
import fr.rowlaxx.binanceapi.api.options.OptionsAPI;
import fr.rowlaxx.binanceapi.api.options.OptionsQuotingAPI;
import fr.rowlaxx.binanceapi.api.options.OptionsTradeAPI;
import fr.rowlaxx.binanceapi.api.spot.BLVTAPI;
import fr.rowlaxx.binanceapi.api.spot.BLVTHttpAPI;
import fr.rowlaxx.binanceapi.api.spot.BSwapAPI;
import fr.rowlaxx.binanceapi.api.spot.C2CAPI;
import fr.rowlaxx.binanceapi.api.spot.ConvertAPI;
import fr.rowlaxx.binanceapi.api.spot.CryptoLoansAPI;
import fr.rowlaxx.binanceapi.api.spot.FiatAPI;
import fr.rowlaxx.binanceapi.api.spot.FuturesAPI;
import fr.rowlaxx.binanceapi.api.spot.GiftcardAPI;
import fr.rowlaxx.binanceapi.api.spot.MarginAPI;
import fr.rowlaxx.binanceapi.api.spot.MiningAPI;
import fr.rowlaxx.binanceapi.api.spot.NFTAPI;
import fr.rowlaxx.binanceapi.api.spot.PayAPI;
import fr.rowlaxx.binanceapi.api.spot.RebateAPI;
import fr.rowlaxx.binanceapi.api.spot.SavingsAPI;
import fr.rowlaxx.binanceapi.api.spot.SpotAPI;
import fr.rowlaxx.binanceapi.api.spot.SpotMarketDataAPI;
import fr.rowlaxx.binanceapi.api.spot.SpotTradeAPI;
import fr.rowlaxx.binanceapi.api.spot.SubAccountAPI;
import fr.rowlaxx.binanceapi.api.spot.WalletAPI;
import fr.rowlaxx.binanceapi.api.usdm.UsdmAPI;
import fr.rowlaxx.binanceapi.api.usdm.UsdmMarketDataAPI;
import fr.rowlaxx.binanceapi.api.usdm.UsdmTradeAPI;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.exceptions.BinanceAPIException;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.utils.ReflectionUtils;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public class BinanceClientImpl implements BinanceClient {
	
	//Variables	
	private CoinmAPI coinm;
	private CoinmMarketDataAPI coinmMarket;
	private CoinmTradeAPI coinmTrade;
	
	private UsdmAPI usdm;
	private UsdmTradeAPI usdmTrade;
	private UsdmMarketDataAPI usdmMarket;
	
	private SpotAPI spot;
	private SpotMarketDataAPI spotMarket;
	private SpotTradeAPI spotTrade;
	
	private OptionsAPI options;
	private OptionsQuotingAPI optionsQuoting;
	private OptionsTradeAPI optionsTrade;
	
	private BLVTAPI blvt;
	private BLVTHttpAPI blvtHttp;
	
	private BSwapAPI bswap;
	private C2CAPI c2c;
	private ConvertAPI convert;
	private CryptoLoansAPI cryptoloans;
	private FiatAPI fiat;
	private FuturesAPI futures;
	private GiftcardAPI giftcard;
	private MarginAPI margin;
	private MiningAPI mining;
	private NFTAPI nft;
	private PayAPI pay;
	private RebateAPI rebate;
	private SavingsAPI savings;
	private SubAccountAPI subaccount;
	private WalletAPI wallet;
	
	
	private Boolean logged = null;
	private final BinanceCredenticals credenticals;
	private final BinanceHttpClient httpClient;
			
	//Constructeurs
	BinanceClientImpl(String apiKey, String apiSecret) {
		this(new BinanceCredenticals(apiKey, apiSecret));
	}
	
	@SuppressWarnings("unchecked")
	BinanceClientImpl(BinanceCredenticals credenticals) {
		this.credenticals = credenticals;
		this.httpClient = new BinanceHttpClient(this);
				
		Api api;
		Class<? extends Api> clazz;
		for (Field field : BinanceClientImpl.class.getDeclaredFields()) {
			if (!Api.class.isAssignableFrom(field.getType()))
				continue;
			
			clazz = (Class<? extends Api>) field.getType();
			api = ApiImplementer.implementz(clazz, this);
			ReflectionUtils.trySet(field, this, api);
		}
		
		this.usdm = new UsdmAPI(usdmMarket, usdmTrade);
		this.coinm = new CoinmAPI(coinmMarket, coinmTrade);
		this.options = new OptionsAPI(optionsQuoting, optionsTrade);
		this.spot = new SpotAPI(spotMarket, spotTrade);
		this.blvt = new BLVTAPI(blvtHttp);
	}
	
	//Méthodes
	@Override
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

	@Override
	public BinanceHttpClient getHttpClient() {
		return httpClient;
	}

	@Override
	public boolean isGuest() {
		return credenticals == null;
	}
	
	@Override
	public boolean isLogged() {
		if (isGuest())
			throw new BinanceAPIException("You cannot use this method on a guest client.");
		if (logged == null)
			throw new BinanceAPIException("Please use the method BinanceClient.login() before calling this method.");
		return logged;
	}
	
	//Methodes
	@Override
	public WalletAPI wallet() {
		return this.wallet;
	}

	@Override
	public BLVTAPI blvt() {
		return blvt;
	}

	@Override
	public BSwapAPI bswap() {
		return bswap;
	}

	@Override
	public C2CAPI c2c() {
		return c2c;
	}

	@Override
	public CoinmAPI coinm() {
		return coinm;
	}

	@Override
	public ConvertAPI convert() {
		return convert;
	}

	@Override
	public CryptoLoansAPI cryptoloans() {
		return cryptoloans;
	}

	@Override
	public FiatAPI fiat() {
		return fiat;
	}

	@Override
	public FuturesAPI futures() {
		return futures;
	}

	@Override
	public GiftcardAPI giftcard() {
		return giftcard;
	}

	@Override
	public MarginAPI margin() {
		return margin;
	}

	@Override
	public MiningAPI mining() {
		return mining;
	}

	@Override
	public NFTAPI nft() {
		return nft;
	}

	@Override
	public OptionsAPI options() {
		return options;
	}

	@Override
	public PayAPI pay() {
		return pay;
	}

	@Override
	public RebateAPI rebate() {
		return rebate;
	}

	@Override
	public SavingsAPI savings() {
		return savings;
	}

	@Override
	public SpotAPI spot() {
		return spot;
	}

	@Override
	public SubAccountAPI subaccount() {
		return subaccount;
	}
	
	@Override
	public UsdmAPI usdm() {
		return usdm;
	}
}
