package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.crosscollateralliquidationhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class CrossCollateralLiquidationHistory extends JSavONObject {
	private static final long serialVersionUID = 3276688664326900486L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public CrossCollateralLiquidationHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Rows> getRows() {
		return this.rows;
	}
	
	public final int getTotal() {
		return this.total;
	}
}