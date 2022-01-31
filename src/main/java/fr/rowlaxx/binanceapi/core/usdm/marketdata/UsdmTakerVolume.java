package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class UsdmTakerVolume extends JsavonObject {
	private static final long serialVersionUID = 7545690185322310608L;
	
	//Variables
	private double buySellRatio;
	private double buyVol;
	private double sellVol;
	private long timestamp;
	
	//Constructeurs
	public UsdmTakerVolume(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBuySellRatio() {
		return this.buySellRatio;
	}
	
	public final double getBuyVol() {
		return this.buyVol;
	}
	
	public final double getSellVol() {
		return this.sellVol;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
}