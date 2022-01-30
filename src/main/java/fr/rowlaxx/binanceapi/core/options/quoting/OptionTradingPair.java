package fr.rowlaxx.binanceapi.core.options.quoting;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;
import fr.rowlaxx.binanceapi.core.exchangeinfos.Filters;
import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.ManualValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class OptionTradingPair extends JsavonObject {
	private static final long serialVersionUID = 8309470448559734149L;
	
	//Variables
	private double autoReduceMargin;
	private int contractId;
	private long expiryDate;
	@ManualValue private Map<Filters, Filter> filters;
	private int id;
	private double initialMargin;
	private int leverage;
	private double maintenanceMargin;
	private double makerFeeRate;
	private int maxQty;
	private double minAutoReduceMargin;
	private double minInitialMargin;
	private double minMaintenanceMargin;
	private int minQty;
	private int priceScale;
	private int quantityScale;
	private String quoteAsset;
	private String side;
	private int strikePrice;
	private String symbol;
	private double takerFeeRate;
	private String underlying;
	private int unit;
	
	//Constructeurs
	public OptionTradingPair(JSONObject json) {
		super(json);
		
		final HashMap<Filters, Filter> filters = new HashMap<>();
		final JSONArray array = json.getJSONArray("filters");
		Filter filter;
		for (int i = 0 ; i < array.length() ; i++) {
			filter = Filter.fromJson( array.getJSONObject(i) );
			filters.put(filter.getFilterType(), filter);
		}
		
		this.filters = Collections.unmodifiableMap(filters);
	}
	
	//Getters
	public final double getAutoReduceMargin() {
		return this.autoReduceMargin;
	}
	
	public final int getContractId() {
		return this.contractId;
	}
	
	public final long getExpiryDate() {
		return this.expiryDate;
	}
	
	public final Filter getFilter(Filters filter) {
		return this.filters.get(filter);
	}
	
	public final Map<Filters, Filter> getFilters() {
		return this.filters;
	}
	
	public final int getId() {
		return this.id;
	}
	
	public final double getInitialMargin() {
		return this.initialMargin;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getMaintenanceMargin() {
		return this.maintenanceMargin;
	}
	
	public final double getMakerFeeRate() {
		return this.makerFeeRate;
	}
	
	public final int getMaxQty() {
		return this.maxQty;
	}
	
	public final double getMinAutoReduceMargin() {
		return this.minAutoReduceMargin;
	}
	
	public final double getMinInitialMargin() {
		return this.minInitialMargin;
	}
	
	public final double getMinMaintenanceMargin() {
		return this.minMaintenanceMargin;
	}
	
	public final int getMinQty() {
		return this.minQty;
	}
	
	public final int getPriceScale() {
		return this.priceScale;
	}
	
	public final int getQuantityScale() {
		return this.quantityScale;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final int getStrikePrice() {
		return this.strikePrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getTakerFeeRate() {
		return this.takerFeeRate;
	}
	
	public final String getUnderlying() {
		return this.underlying;
	}
	
	public final int getUnit() {
		return this.unit;
	}
}