package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class MaxAmount extends JsavonObject {
	private static final long serialVersionUID = -4481165629594289388L;
	
	//Variables
	private double maxInAmount;
	private double maxOutAmount;
	
	//Constructeurs
	public MaxAmount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMaxInAmount() {
		return this.maxInAmount;
	}
	
	public final double getMaxOutAmount() {
		return this.maxOutAmount;
	}
}