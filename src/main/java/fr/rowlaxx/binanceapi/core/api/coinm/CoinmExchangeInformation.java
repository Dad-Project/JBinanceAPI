package fr.rowlaxx.binanceapi.core.api.coinm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.ExchangeInformation;

public class CoinmExchangeInformation extends ExchangeInformation<CoinmSymbol> {
	private static final long serialVersionUID = -6353085621084475074L;

	//Constructeurs
	public CoinmExchangeInformation(JSONObject response) {
		super(response);
	}

}
