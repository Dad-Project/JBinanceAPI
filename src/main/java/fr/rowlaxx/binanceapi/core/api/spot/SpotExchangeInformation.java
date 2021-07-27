package fr.rowlaxx.binanceapi.core.api.spot;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.ExchangeInformation;

public class SpotExchangeInformation extends ExchangeInformation<SpotSymbol> {
	private static final long serialVersionUID = 2887969122906405748L;

	//Constructeurs
	public SpotExchangeInformation(JSONObject response) {
		super(response);
	}

}
