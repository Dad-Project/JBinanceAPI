package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class MaxPositionFilter extends Filter {
	private static final long serialVersionUID = 4409062075075074771L;

	//Variables
	private double maxPosition;

	//Constructeurs
	public MaxPositionFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMaxPosition() {
		return maxPosition;
	}
}