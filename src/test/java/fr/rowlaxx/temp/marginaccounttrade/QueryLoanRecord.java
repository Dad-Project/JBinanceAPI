package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.queryloanrecord.Rows;

import java.util.List;

import org.json.JSONObject;

public class QueryLoanRecord extends JSavONObject {
	private static final long serialVersionUID = 2691263210318922871L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public QueryLoanRecord(JSONObject json) {
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