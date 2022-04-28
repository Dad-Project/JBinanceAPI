package fr.rowlaxx.binanceapi.client;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.api.coinm.CoinmAPI;
import fr.rowlaxx.binanceapi.api.options.OptionsAPI;
import fr.rowlaxx.binanceapi.api.spot.BLVTAPI;
import fr.rowlaxx.binanceapi.api.spot.BSwapAPI;
import fr.rowlaxx.binanceapi.api.spot.C2CAPI;
import fr.rowlaxx.binanceapi.api.spot.ConvertAPI;
import fr.rowlaxx.binanceapi.api.spot.CryptoLoansAPI;
import fr.rowlaxx.binanceapi.api.spot.FiatAPI;
import fr.rowlaxx.binanceapi.api.spot.FuturesAPI;
import fr.rowlaxx.binanceapi.api.spot.FuturesAlgoAPI;
import fr.rowlaxx.binanceapi.api.spot.GiftcardAPI;
import fr.rowlaxx.binanceapi.api.spot.MarginAPI;
import fr.rowlaxx.binanceapi.api.spot.MiningAPI;
import fr.rowlaxx.binanceapi.api.spot.NFTAPI;
import fr.rowlaxx.binanceapi.api.spot.PayAPI;
import fr.rowlaxx.binanceapi.api.spot.RebateAPI;
import fr.rowlaxx.binanceapi.api.spot.SavingsAPI;
import fr.rowlaxx.binanceapi.api.spot.SpotAPI;
import fr.rowlaxx.binanceapi.api.spot.StakingAPI;
import fr.rowlaxx.binanceapi.api.spot.SubAccountAPI;
import fr.rowlaxx.binanceapi.api.spot.WalletAPI;
import fr.rowlaxx.binanceapi.api.usdm.UsdmAPI;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;

public class BinanceClientImpl implements BinanceClient {
	
	//Variables	
	private SpotAPI spot = null;
	private BLVTAPI blvt = null;
	private MarginAPI margin = null;
	private UsdmAPI usdm = null;
	private CoinmAPI coinm = null;
	private OptionsAPI options = null;
	private BSwapAPI bswap = null;
	private C2CAPI c2c = null;
	private ConvertAPI convert = null;
	private CryptoLoansAPI cryptoloans = null;
	private FiatAPI fiat = null;
	private FuturesAPI futures = null;
	private FuturesAlgoAPI futuresalgo = null;
	private GiftcardAPI giftcard = null;
	private MiningAPI mining = null;
	private NFTAPI nft = null;
	private PayAPI pay = null;
	private RebateAPI rebate = null;
	private SavingsAPI savings = null;
	private StakingAPI staking = null;
	private SubAccountAPI subaccount = null;
	private WalletAPI wallet = null;
	
	private final BinanceCredenticals credenticals;
	private final BinanceHttpClient httpClient;
			
	//Constructeurs
	BinanceClientImpl(String apiKey, String apiSecret) {
		this(new BinanceCredenticals(apiKey, apiSecret));
	}
	
	BinanceClientImpl(BinanceCredenticals credenticals) {
		this.credenticals = credenticals;
		this.httpClient = new BinanceHttpClient(this);
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
	
	//Methodes
	@Override
	public WalletAPI wallet() {
		if (wallet == null)
			wallet = ApiImplementer.implementz(WalletAPI.class, this);
		return this.wallet;
	}

	@Override
	public BLVTAPI blvt() {
		if (blvt == null)
			blvt = new BLVTAPI(this);
		return blvt;
	}

	@Override
	public BSwapAPI bswap() {
		if (bswap == null)
			bswap = ApiImplementer.implementz(BSwapAPI.class, this);
		return bswap;
	}

	@Override
	public C2CAPI c2c() {
		if (c2c == null)
			c2c = ApiImplementer.implementz(C2CAPI.class, this);
		return c2c;
	}

	@Override
	public CoinmAPI coinm() {
		if (coinm == null)
			coinm = new CoinmAPI(this);
		return coinm;
	}

	@Override
	public ConvertAPI convert() {
		if (convert == null)
			convert = ApiImplementer.implementz(ConvertAPI.class, this);
		return convert;
	}

	@Override
	public CryptoLoansAPI cryptoloans() {
		if (cryptoloans == null)
			cryptoloans = ApiImplementer.implementz(CryptoLoansAPI.class, this);
		return cryptoloans;
	}

	@Override
	public FiatAPI fiat() {
		if (fiat == null)
			fiat = ApiImplementer.implementz(FiatAPI.class, this);
		return fiat;
	}

	@Override
	public FuturesAPI futures() {
		if (futures == null)
			futures = ApiImplementer.implementz(FuturesAPI.class, this);
		return futures;
	}

	@Override
	public GiftcardAPI giftcard() {
		if (giftcard == null)
			giftcard = ApiImplementer.implementz(GiftcardAPI.class, this);
		return giftcard;
	}

	@Override
	public MarginAPI margin() {
		if (margin == null)
			margin = new MarginAPI(this);
		return margin;
	}

	@Override
	public MiningAPI mining() {
		if (mining == null)
			mining = ApiImplementer.implementz(MiningAPI.class, this);
		return mining;
	}

	@Override
	public NFTAPI nft() {
		if (nft == null)
			nft = ApiImplementer.implementz(NFTAPI.class, this);
		return nft;
	}

	@Override
	public OptionsAPI options() {
		if (options == null)
			options = new OptionsAPI(this);
		return options;
	}

	@Override
	public PayAPI pay() {
		if (pay == null)
			pay = ApiImplementer.implementz(PayAPI.class, this);
		return pay;
	}

	@Override
	public RebateAPI rebate() {
		if (rebate == null)
			rebate = ApiImplementer.implementz(RebateAPI.class, this);
		return rebate;
	}

	@Override
	public SavingsAPI savings() {
		if (savings == null)
			savings = ApiImplementer.implementz(SavingsAPI.class, this);
		return savings;
	}

	@Override
	public SpotAPI spot() {
		if (spot == null)
			spot = new SpotAPI(this);
		return spot;
	}
	
	@Override
	public StakingAPI staking() {
		if (staking == null)
			staking = ApiImplementer.implementz(StakingAPI.class, this);
		return staking;
	}

	@Override
	public SubAccountAPI subaccount() {
		if (subaccount == null)
			subaccount = ApiImplementer.implementz(SubAccountAPI.class, this);
		return subaccount;
	}
	
	@Override
	public FuturesAlgoAPI futuresalgo() {
		if (futuresalgo == null)
			futuresalgo = ApiImplementer.implementz(FuturesAlgoAPI.class, this);
		return futuresalgo;
	}
	
	@Override
	public UsdmAPI usdm() {
		if (usdm == null)
			usdm = new UsdmAPI(this);
		return usdm;
	}
}
