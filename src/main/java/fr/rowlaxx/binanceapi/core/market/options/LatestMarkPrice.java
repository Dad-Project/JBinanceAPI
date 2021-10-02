package fr.rowlaxx.binanceapi.core.market.options;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class LatestMarkPrice extends JSavONObject {
	private static final long serialVersionUID = 672323385230440841L;
	
	//Variables
	private double askIV;
	private double bidIV;
	private double delta;
	private double gamma;
	private double highPriceLimit;
	private double lowPriceLimit;
	private double markPrice;
	private String symbol;
	private double theta;
	private double vega;
	
	//Constructeurs
	public LatestMarkPrice(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskIV() {
		return this.askIV;
	}
	
	public final double getBidIV() {
		return this.bidIV;
	}
	
	public final double getDelta() {
		return this.delta;
	}
	
	public final double getGamma() {
		return this.gamma;
	}
	
	public final double getHighPriceLimit() {
		return this.highPriceLimit;
	}
	
	public final double getLowPriceLimit() {
		return this.lowPriceLimit;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getTheta() {
		return this.theta;
	}
	
	public final double getVega() {
		return this.vega;
	}
}