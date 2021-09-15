package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.adjustcrosscollateralltvhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class AdjustCrossCollateralLTVHistory extends JSavONObject {
	private static final long serialVersionUID = -4292390423585748254L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public AdjustCrossCollateralLTVHistory(JSONObject json) {
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