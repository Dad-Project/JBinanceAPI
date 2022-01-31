package fr.rowlaxx.binanceapi.core.futures.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class LongShortRatio extends JsavonObject {
	private static final long serialVersionUID = 966595479160773630L;
	
	private double longShortRatio;
	private long timestamp;
	
	//Constructeurs
	public LongShortRatio(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getLongShortRatio() {
		return this.longShortRatio;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
}