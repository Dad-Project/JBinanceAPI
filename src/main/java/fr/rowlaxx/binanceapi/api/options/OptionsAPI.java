package fr.rowlaxx.binanceapi.api.options;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public final class OptionsAPI {

	//Variables
	private final BinanceClient client;
	
	private OptionsQuotingAPI quoting;
	private OptionsTradeAPI trade;
	
	//Constructeurs
	public OptionsAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}
	
	//Methodes
	public OptionsQuotingAPI quoting() {
		if (quoting == null)
			quoting = ApiImplementer.implementz(OptionsQuotingAPI.class, client);
		return quoting;
	}
	
	public OptionsTradeAPI trade() {
		if (trade == null)
			trade = ApiImplementer.implementz(OptionsTradeAPI.class, client);
		return trade;
	}
}
