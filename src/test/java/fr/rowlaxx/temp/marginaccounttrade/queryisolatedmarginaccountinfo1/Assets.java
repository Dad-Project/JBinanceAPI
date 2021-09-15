package fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo1;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo1.assets.BaseAsset;
import fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo1.assets.QuoteAsset;

import org.json.JSONObject;

public class Assets extends JSavONObject {
	private static final long serialVersionUID = 6754986597350671872L;
	
	//Variables
	private BaseAsset baseAsset;
	private boolean enabled;
	private double indexPrice;
	private boolean isolatedCreated;
	private double liquidatePrice;
	private double liquidateRate;
	private double marginLevel;
	private String marginLevelStatus;
	private double marginRatio;
	private QuoteAsset quoteAsset;
	private String symbol;
	private boolean tradeEnabled;
	
	//Constructeurs
	public Assets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final BaseAsset getBaseAsset() {
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
	
	public final QuoteAsset getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final boolean isTradeEnabled() {
		return this.tradeEnabled;
	}
}