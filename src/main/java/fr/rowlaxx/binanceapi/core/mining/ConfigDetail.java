package fr.rowlaxx.binanceapi.core.mining;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class ConfigDetail extends JSavONObject {
	private static final long serialVersionUID = -5386134546533663433L;
	
	//Variables
	private String algoName;
	private int configId;
	private int endDay;
	private int hashRate;
	private int poolUsername;
	private int startDay;
	private int status;
	private String toPoolUsername;
	
	//Constructeurs
	public ConfigDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAlgoName() {
		return this.algoName;
	}
	
	public final int getConfigId() {
		return this.configId;
	}
	
	public final int getEndDay() {
		return this.endDay;
	}
	
	public final int getHashRate() {
		return this.hashRate;
	}
	
	public final int getPoolUsername() {
		return this.poolUsername;
	}
	
	public final int getStartDay() {
		return this.startDay;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final String getToPoolUsername() {
		return this.toPoolUsername;
	}
}