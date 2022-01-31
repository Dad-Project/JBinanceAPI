package fr.rowlaxx.binanceapi.core.futures.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class PremiumIndex extends JsavonObject {
	private static final long serialVersionUID = -2956979926418535772L;
	
	//Variables
	private double estimatedSettlePrice;
	private double indexPrice;
	private double interestRate;
	private double lastFundingRate;
	private double markPrice;
	private long nextFundingTime;
	@JOValue(mandatory = false) private String pair;
	private String symbol;
	private long time;
	
	//Constructeurs
	public PremiumIndex(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getEstimatedSettlePrice() {
		return this.estimatedSettlePrice;
	}
	
	public final double getIndexPrice() {
		return this.indexPrice;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final double getLastFundingRate() {
		return this.lastFundingRate;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final long getNextFundingTime() {
		return this.nextFundingTime;
	}
	
	public final String getPair() {
		return this.pair;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}