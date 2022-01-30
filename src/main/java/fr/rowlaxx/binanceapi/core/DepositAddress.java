package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class DepositAddress extends JsavonObject {
	private static final long serialVersionUID = 5872502337723190174L;
	
	//Variables
	private String address;
	private String coin;
	private String tag;
	private String url;
	
	//Constructeurs
	public DepositAddress(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAddress() {
		return this.address;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getTag() {
		return this.tag;
	}
	
	public final String getUrl() {
		return this.url;
	}
}