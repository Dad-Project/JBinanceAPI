package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.ExchangeInformation;

public class CoinmExchangeInformation extends ExchangeInformation<CoinmSymbol> {
	private static final long serialVersionUID = -6353085621084475074L;

	//Constructeurs
	public CoinmExchangeInformation(JSONObject response) {
		super(response);
	}

}
