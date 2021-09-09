package fr.rowlaxx.binanceapi.core.general;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.OrderTypes;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class SimpleSymbol<T extends OrderTypes> extends Symbol {
	private static final long serialVersionUID = -2491528525290759925L;

	//Variables
	@JOValue private String baseAsset;
	@JOValue private int baseAssetPrecision;
	@JOValue private int quotePrecision;
	@JOValue private Set<T> orderTypes;
	
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
	
	public Set<T> getOrderTypes() {
		return orderTypes;
	}
	
	public boolean hasOrderType(T orderType) {
		return orderTypes.contains(orderType);
	}

}
