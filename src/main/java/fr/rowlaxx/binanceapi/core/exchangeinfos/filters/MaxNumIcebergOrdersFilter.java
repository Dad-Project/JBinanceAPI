package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class MaxNumIcebergOrdersFilter extends Filter {
	private static final long serialVersionUID = -5344004179253185313L;
	
	//Variables
	private int maxNumIcebergOrders;

	//Constructeurs
	public MaxNumIcebergOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumIcebergOrders() {
		return maxNumIcebergOrders;
	}
}