package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class MaxNumIcebergOrdersFilter extends Filter {
	private static final long serialVersionUID = -5344004179253185313L;
	
	//Variables
	@JOValue private int maxNumIcebergOrders;

	//Constructeurs
	public MaxNumIcebergOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumIcebergOrders() {
		return maxNumIcebergOrders;
	}
}