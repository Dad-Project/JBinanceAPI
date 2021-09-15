package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CheckServerTime extends JSavONObject {
	private static final long serialVersionUID = 7718724057281797200L;
	
	//Variables
	private long serverTime;
	
	//Constructeurs
	public CheckServerTime(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getServerTime() {
		return this.serverTime;
	}
}