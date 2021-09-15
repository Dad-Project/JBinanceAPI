package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.crosscollateralinteresthistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class CrossCollateralInterestHistory extends JSavONObject {
	private static final long serialVersionUID = -4889297392140948863L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public CrossCollateralInterestHistory(JSONObject json) {
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