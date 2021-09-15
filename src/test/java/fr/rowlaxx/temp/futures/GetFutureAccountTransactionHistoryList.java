package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.getfutureaccounttransactionhistorylist.Rows;

import java.util.List;

import org.json.JSONObject;

public class GetFutureAccountTransactionHistoryList extends JSavONObject {
	private static final long serialVersionUID = 6825847060947506485L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public GetFutureAccountTransactionHistoryList(JSONObject json) {
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