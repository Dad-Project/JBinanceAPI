package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class AssetConfigure extends JsavonObject {
	private static final long serialVersionUID = -2889642633793927927L;
	
	//Variables
	private double minAdd, maxAdd, minSwap, maxSwap;
	
	//Constructeurs
	public AssetConfigure(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMaxAdd() {
		return maxAdd;
	}
	
	public final double getMaxSwap() {
		return maxSwap;
	}
	
	public final double getMinAdd() {
		return minAdd;
	}
	
	public final double getMinSwap() {
		return minSwap;
	}
}
