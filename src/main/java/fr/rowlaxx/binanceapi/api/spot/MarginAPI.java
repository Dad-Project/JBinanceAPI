package fr.rowlaxx.binanceapi.api.spot;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public class MarginAPI {

	//Variables
	private final BinanceClient client;
	
	private MarginTradeAPI trade = null;
	private PortfolioMarginApi portfolio = null;
	private SpotUserStreamAPI userstream = null;
	private SpotUserStreamAPI isolateduserstream = null;
	
	//Constructeurs
	public MarginAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}
	
	//Methodes
	public SpotUserStreamAPI crossuserstream() {
		if (userstream == null)
			userstream = new SpotUserStreamAPI(client.getHttpClient(), "/sapi/v1/userDataStream");
		return userstream;
	}
	
	public SpotUserStreamAPI isolateduserstream() {
		if (isolateduserstream == null)
			isolateduserstream = new SpotUserStreamAPI(client.getHttpClient(), "/sapi/v1/userDataStream/isolated");
		return isolateduserstream;
	}
	
	public MarginTradeAPI trade() {
		if (trade == null)
			trade = ApiImplementer.implementz(MarginTradeAPI.class, client);
		return trade;
	}
	
	public PortfolioMarginApi portfolio() {
		if (portfolio == null)
			portfolio = ApiImplementer.implementz(PortfolioMarginApi.class, client);
		return portfolio;
	}
}
