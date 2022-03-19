package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.util.Objects;

import fr.rowlaxx.binanceapi.api.coinm.CoinmAPI;
import fr.rowlaxx.binanceapi.api.options.OptionsAPI;
import fr.rowlaxx.binanceapi.api.spot.BLVTAPI;
import fr.rowlaxx.binanceapi.api.spot.BSwapAPI;
import fr.rowlaxx.binanceapi.api.spot.GiftcardAPI;
import fr.rowlaxx.binanceapi.api.spot.C2CAPI;
import fr.rowlaxx.binanceapi.api.spot.ConvertAPI;
import fr.rowlaxx.binanceapi.api.spot.CryptoLoansAPI;
import fr.rowlaxx.binanceapi.api.spot.FiatAPI;
import fr.rowlaxx.binanceapi.api.spot.FuturesAPI;
import fr.rowlaxx.binanceapi.api.spot.MarginAPI;
import fr.rowlaxx.binanceapi.api.spot.MiningAPI;
import fr.rowlaxx.binanceapi.api.spot.NFTAPI;
import fr.rowlaxx.binanceapi.api.spot.PayAPI;
import fr.rowlaxx.binanceapi.api.spot.RebateAPI;
import fr.rowlaxx.binanceapi.api.spot.SavingsAPI;
import fr.rowlaxx.binanceapi.api.spot.SpotAPI;
import fr.rowlaxx.binanceapi.api.spot.SubAccountAPI;
import fr.rowlaxx.binanceapi.api.spot.WalletAPI;
import fr.rowlaxx.binanceapi.api.usdm.UsdmAPI;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;

public interface BinanceClient {

	//Methodes statiques
	public static BinanceClient createGuest() {
		return new BinanceClientImpl(null);
	}

	public static BinanceClient create(final String apiKey, final String apiSecret) {
		return new BinanceClientImpl(apiKey, apiSecret);
	}

	public static BinanceClient create(final BinanceCredenticals credenticals) {
		Objects.requireNonNull(credenticals, "credenticals may not be null.");
		return new BinanceClientImpl(credenticals);
	}

	public boolean login() throws IOException;
	public boolean isLogged();
	public boolean isGuest();
	public BinanceHttpClient getHttpClient();

	/*
	 * SPOT
	 * https://binance-docs.github.io/apidocs/spot/en/
	 */
	public SpotAPI spot();
	public WalletAPI wallet();
	public SubAccountAPI subaccount();
	public MarginAPI margin();
	public SavingsAPI savings();
	public MiningAPI mining();
	public FuturesAPI futures();
	public BLVTAPI blvt();
	public BSwapAPI bswap();
	public FiatAPI fiat();
	public C2CAPI c2c();
	public CryptoLoansAPI cryptoloans();
	public PayAPI pay();
	public ConvertAPI convert();
	public RebateAPI rebate();
	public NFTAPI nft();
	public GiftcardAPI giftcard();

	/*
	 * OPTIONS 
	 * https://binance-docs.github.io/apidocs/voptions/en/
	 */
	public OptionsAPI options();

	/*
	 * USD-M
	 * https://binance-docs.github.io/apidocs/futures/en/
	 */
	public UsdmAPI usdm();

	/*
	 * COIN-M
	 * https://binance-docs.github.io/apidocs/delivery/en/
	 */
	public CoinmAPI coinm();
}
