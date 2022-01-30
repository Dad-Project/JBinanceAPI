package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class MarginUserAsset extends JsavonObject {
	private static final long serialVersionUID = -8927603325686347569L;
	
	//Variables
	private BaseQuoteAsset baseAsset;
	private boolean enabled;
	private double indexPrice;
	private boolean isolatedCreated;
	private double liquidatePrice;
	private double liquidateRate;
	private double marginLevel;
	private String marginLevelStatus;
	private double marginRatio;
	private BaseQuoteAsset quoteAsset;
	private String symbol;
	private boolean tradeEnabled;
	
	//Constructeurs
	public MarginUserAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final BaseQuoteAsset getBaseAsset() {
		return this.baseAsset;
	}
	
	public final boolean isEnabled() {
		return this.enabled;
	}
	
	public final double getIndexPrice() {
		return this.indexPrice;
	}
	
	public final boolean isOlatedCreated() {
		return this.isolatedCreated;
	}
	
	public final double getLiquidatePrice() {
		return this.liquidatePrice;
	}
	
	public final double getLiquidateRate() {
		return this.liquidateRate;
	}
	
	public final double getMarginLevel() {
		return this.marginLevel;
	}
	
	public final String getMarginLevelStatus() {
		return this.marginLevelStatus;
	}
	
	public final double getMarginRatio() {
		return this.marginRatio;
	}
	
	public final BaseQuoteAsset getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final boolean isTradeEnabled() {
		return this.tradeEnabled;
	}
}