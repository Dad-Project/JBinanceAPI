package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Quota extends JsavonObject {
	private static final long serialVersionUID = 464566317675746179L;
	
	//Variables
	private String asset;
	private double leftQuota;
	
	//Constructeurs
	public Quota(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getLeftQuota() {
		return this.leftQuota;
	}
}