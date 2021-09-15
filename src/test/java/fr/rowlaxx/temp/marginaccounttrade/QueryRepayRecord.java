package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.queryrepayrecord.Rows;

import java.util.List;

import org.json.JSONObject;

public class QueryRepayRecord extends JSavONObject {
	private static final long serialVersionUID = -1422888619642362422L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public QueryRepayRecord(JSONObject json) {
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