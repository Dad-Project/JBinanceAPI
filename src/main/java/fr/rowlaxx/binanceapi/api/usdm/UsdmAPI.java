package fr.rowlaxx.binanceapi.api.usdm;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public final class UsdmAPI {

	//Variables
	private final BinanceClient client;
	
	private UsdmMarketDataAPI market;
	private UsdmTradeAPI trade;
	
	//Constructeurs
	public UsdmAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}
	
	//Methodes
	public UsdmMarketDataAPI market() {
		if (market == null)
			market = ApiImplementer.implementz(UsdmMarketDataAPI.class, client);
		return market;
	}
	
	public UsdmTradeAPI trade() {
		if (trade == null)
			trade = ApiImplementer.implementz(UsdmTradeAPI.class, client);
		return trade;
	}	
}
