package fr.rowlaxx.binanceapi.core.mining;

import fr.rowlaxx.jsavon.JSavONObject;
import java.util.Map;

import org.json.JSONObject;

public class MiningStatistics extends JSavONObject {
	private static final long serialVersionUID = 88885892338114433L;
	
	//Variables
	private String algo;
	private double dayHashRate;
	private double fifteenMinHashRate;
	private int invalidNum;
	private Map<String, Double> profitToday;
	private Map<String, Double> profitYesterday;
	private String unit;
	private String userName;
	private int validNum;
	
	//Constructeurs
	public MiningStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAlgo() {
		return this.algo;
	}
	
	public final double getDayHashRate() {
		return this.dayHashRate;
	}
	
	public final double getFifteenMinHashRate() {
		return this.fifteenMinHashRate;
	}
	
	public final int getInvalidNum() {
		return this.invalidNum;
	}
	
	public final Map<String, Double> getProfitToday() {
		return profitToday;
	}
	
	public final Double getProfitToday(String coin) {
		return profitToday.get(coin);
	}
	
	public final Map<String, Double> getProfitYesterday() {
		return profitYesterday;
	}
	
	public final Double getProfitYesterday(String coin) {
		return profitYesterday.get(coin);
	}
	
	public final String getUnit() {
		return this.unit;
	}
	
	public final String getUserName() {
		return this.userName;
	}
	
	public final int getValidNum() {
		return this.validNum;
	}
}