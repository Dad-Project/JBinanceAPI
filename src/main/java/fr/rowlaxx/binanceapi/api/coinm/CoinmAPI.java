package fr.rowlaxx.binanceapi.api.coinm;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public final class CoinmAPI {

	//Variables
	private final BinanceClient client;

	private CoinmMarketDataAPI market;
	private CoinmTradeAPI trade;

	//Constructeurs
	public CoinmAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}

	//Methodes
	public CoinmMarketDataAPI market() {
		if (market == null)
			market = ApiImplementer.implementz(CoinmMarketDataAPI.class, client);
		return market;
	}

	public CoinmTradeAPI trade() {
		if (trade == null)
			trade = ApiImplementer.implementz(CoinmTradeAPI.class, client);
		return trade;
	}	

}
