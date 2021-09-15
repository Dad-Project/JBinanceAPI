package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.getinteresthistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class GetInterestHistory extends JSavONObject {
	private static final long serialVersionUID = 2083781892713213906L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public GetInterestHistory(JSONObject json) {
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