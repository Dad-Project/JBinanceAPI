package fr.rowlaxx.binanceapi.core.market.spot;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class CurrentAveragePrice extends JsavonObject {
	private static final long serialVersionUID = -1092219404614702932L;
	
	//Variables
	private int mins;
	private double price;
	
	//Constructeurs
	public CurrentAveragePrice(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getMins() {
		return this.mins;
	}
	
	public final double getPrice() {
		return this.price;
	}
}