package fr.rowlaxx.binanceapi.core.general;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.OrderTypes;

public abstract class SimpleSymbol<T extends OrderTypes> extends Symbol {
	private static final long serialVersionUID = -2491528525290759925L;

	//Variables
	private String baseAsset;
	private int baseAssetPrecision;
	private int quotePrecision;
	private Set<T> orderTypes;
	
	//Constructeurs
	public SimpleSymbol(JSONObject response) {
		super(response);
	}
	
	public String getBaseAsset() {
		return baseAsset;
	}
	
	public int getQuotePrecision() {
		return quotePrecision;
	}
	
	public int getBaseAssetPrecision() {
		return baseAssetPrecision;
	}
	
	public Set<T> getOrderTypes() {
		return orderTypes;
	}
	
	public boolean hasOrderType(T orderType) {
		return orderTypes.contains(orderType);
	}

}
