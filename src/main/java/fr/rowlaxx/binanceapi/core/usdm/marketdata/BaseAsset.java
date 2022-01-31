package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class BaseAsset extends JsavonObject {
	private static final long serialVersionUID = 7440401857273245878L;
	
	//Variables
	private String baseAsset;
	private String quoteAsset;
	private double weightInPercentage;
	private double weightInQuantity;
	
	//Constructeurs
	public BaseAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBaseAsset() {
		return this.baseAsset;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final double getWeightInPercentage() {
		return this.weightInPercentage;
	}
	
	public final double getWeightInQuantity() {
		return this.weightInQuantity;
	}
}