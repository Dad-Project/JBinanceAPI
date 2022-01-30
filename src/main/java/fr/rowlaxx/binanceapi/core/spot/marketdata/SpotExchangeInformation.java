package fr.rowlaxx.binanceapi.core.spot.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.ExchangeInformation;

public class SpotExchangeInformation extends ExchangeInformation<SpotSymbol> {

	private static final long serialVersionUID = 2887969122906405748L;

	//Constructeurs
	public SpotExchangeInformation(JSONObject response) {
		super(response);
	}
}
