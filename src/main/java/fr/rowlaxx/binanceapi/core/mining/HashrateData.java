package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class HashrateData extends JsavonObject {
	private static final long serialVersionUID = -2989768733168849142L;
	
	//Variables
	private int hashrate;
	private int reject;
	private long time;
	
	//Constructeurs
	public HashrateData(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getHashrate() {
		return this.hashrate;
	}
	
	public final int getReject() {
		return this.reject;
	}
	
	public final long getTime() {
		return this.time;
	}
}