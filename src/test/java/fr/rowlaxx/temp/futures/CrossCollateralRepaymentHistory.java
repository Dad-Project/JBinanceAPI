package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.crosscollateralrepaymenthistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class CrossCollateralRepaymentHistory extends JSavONObject {
	private static final long serialVersionUID = 4673502417114309747L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public CrossCollateralRepaymentHistory(JSONObject json) {
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