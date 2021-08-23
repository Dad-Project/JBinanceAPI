package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;

public class Orderbook extends BinanceResponseJSON {
	private static final long serialVersionUID = -8788146663753662511L;

	//Variables
	
	//Constructeurs
	public Orderbook(JSONObject response) {
		super(response);
	}

}
