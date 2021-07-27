package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MaxPositionFilter extends SymbolFilter {
	private static final long serialVersionUID = 4409062075075074771L;

	//Variables
	@JsonValue private double maxPosition;

	//Constructeurs
	public MaxPositionFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMaxPosition() {
		return maxPosition;
	}
}