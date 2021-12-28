package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;

public class IcebergPartsFilter extends Filter {
	private static final long serialVersionUID = -8589425863338007037L;

	//Variables
	private int limit;

	//Constructeurs
	public IcebergPartsFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getLimit() {
		return limit;
	}
}