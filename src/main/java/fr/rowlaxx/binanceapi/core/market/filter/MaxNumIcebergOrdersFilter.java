package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MaxNumIcebergOrdersFilter extends SymbolFilter {
	private static final long serialVersionUID = -5344004179253185313L;
	
	//Variables
	@JsonValue private int maxNumIcebergOrders;

	//Constructeurs
	public MaxNumIcebergOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumIcebergOrders() {
		return maxNumIcebergOrders;
	}
}