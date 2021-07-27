package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class IcebergPartsFilter extends SymbolFilter {
	private static final long serialVersionUID = -8589425863338007037L;

	//Variables
	@JsonValue private int limit;

	//Constructeurs
	public IcebergPartsFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getLimit() {
		return limit;
	}
}