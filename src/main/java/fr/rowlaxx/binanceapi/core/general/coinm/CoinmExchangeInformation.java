package fr.rowlaxx.binanceapi.core.general.coinm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.SimpleExchangeInformation;

public class CoinmExchangeInformation extends SimpleExchangeInformation<CoinmSymbol> {
	private static final long serialVersionUID = -6353085621084475074L;

	//Constructeurs
	public CoinmExchangeInformation(JSONObject response) {
		super(response);
	}

}
