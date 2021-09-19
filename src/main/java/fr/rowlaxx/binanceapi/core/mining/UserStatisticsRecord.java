package fr.rowlaxx.binanceapi.core.mining;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UserStatisticsRecord extends JSavONObject {
	private static final long serialVersionUID = -2559045516902850133L;
	
	//Variables
	private double hashrate;
	private double reject;
	private long time;
	
	//Constructeurs
	public UserStatisticsRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getHashrate() {
		return this.hashrate;
	}
	
	public final double getReject() {
		return this.reject;
	}
	
	public final long getTime() {
		return this.time;
	}
}