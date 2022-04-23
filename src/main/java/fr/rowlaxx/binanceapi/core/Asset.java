package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class Asset extends JsavonObject {
	private static final long serialVersionUID = -8246393742905404438L;
	
	//Variables
	@JOValue(key = {"asset", "a"})
	private String asset;
	@JOValue(key = {"free", "f"})
	private double free;
	@JOValue(key = {"locked", "l"})
	private double locked;
	
	//Constructeurs
	public Asset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getFree() {
		return this.free;
	}
	
	public final double getLocked() {
		return this.locked;
	}
}