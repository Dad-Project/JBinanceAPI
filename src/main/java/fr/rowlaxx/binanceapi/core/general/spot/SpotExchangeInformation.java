package fr.rowlaxx.binanceapi.core.general.spot;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.SimpleExchangeInformation;

public class SpotExchangeInformation extends SimpleExchangeInformation<SpotSymbol> {

	private static final long serialVersionUID = 2887969122906405748L;

	//Constructeurs
	public SpotExchangeInformation(JSONObject response) {
		super(response);
	}
}
