package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.crosscollateralborrowhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class CrossCollateralBorrowHistory extends JSavONObject {
	private static final long serialVersionUID = 8198371626476898376L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public CrossCollateralBorrowHistory(JSONObject json) {
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