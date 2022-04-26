package fr.rowlaxx.binanceapi.core.futures.marketstream;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class MarkPrice extends JsavonObject {
	private static final long serialVersionUID = 7348239920728473102L;

	//Variables
	@JOValue(key = "s")
	private String symbol;
	@JOValue(key = "i", mandatory = false)
	private Double indexPrice;
	@JOValue(key = "p")
	private double markPrice;
	@JOValue(key = "P")
	private double estimatedSettlementPrice;
	@JOValue(key = "f")
	private double fundingRate;
	@JOValue(key = "T")
	private long nextFundingTime;
	
	//Getters
	public double getEstimatedSettlementPrice() {
		return estimatedSettlementPrice;
	}
	
	public double getFundingRate() {
		return fundingRate;
	}
	
	public double getIndexPrice() {
		return indexPrice;
	}
	
	public double getMarkPrice() {
		return markPrice;
	}
	
	public long getNextFundingTime() {
		return nextFundingTime;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
