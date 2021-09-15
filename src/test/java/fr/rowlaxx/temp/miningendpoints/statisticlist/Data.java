package fr.rowlaxx.temp.miningendpoints.statisticlist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.statisticlist.data.ProfitToday;
import fr.rowlaxx.temp.miningendpoints.statisticlist.data.ProfitYesterday;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 88885892338114433L;
	
	//Variables
	private String algo;
	private double dayHashRate;
	private double fifteenMinHashRate;
	private int invalidNum;
	private ProfitToday profitToday;
	private ProfitYesterday profitYesterday;
	private String unit;
	private String userName;
	private int validNum;
	
	//Constructeurs
	public Data(JSONObject json) {
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
	
	public final ProfitToday getProfitToday() {
		return this.profitToday;
	}
	
	public final ProfitYesterday getProfitYesterday() {
		return this.profitYesterday;
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