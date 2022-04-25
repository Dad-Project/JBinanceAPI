package fr.rowlaxx.binanceapi.api.spot;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public final class SpotAPI {
	
	//Variables
	private final BinanceClient client;
	
	private SpotMarketDataAPI market = null;
	private SpotTradeAPI trade = null;	
	private SpotMarketStreamAPI marketstream = null;
	private SpotUserStreamAPI userstream = null;
	
	//Constructeurs
	public SpotAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}
	
	//Methodes
	public SpotMarketDataAPI market() {
		if (market == null)
			market = ApiImplementer.implementz(SpotMarketDataAPI.class, client);
		return market;
	}
	
	public SpotTradeAPI trade() {
		if (trade == null)
			trade = ApiImplementer.implementz(SpotTradeAPI.class, client);
		return trade;
	}
	
	public SpotMarketStreamAPI marketstream() {
		if (marketstream == null)
			marketstream = new SpotMarketStreamAPI();
		return marketstream;
	}
	
	public SpotUserStreamAPI userstream() {
		if (userstream == null)
			userstream = new SpotUserStreamAPI(client, "/api/v3/userDataStream");
		return userstream;
	}
}
