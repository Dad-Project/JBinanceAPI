package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.queryuseruniversaltransferhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class QueryUserUniversalTransferHistory extends JSavONObject {
	private static final long serialVersionUID = -2487711620794532939L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public QueryUserUniversalTransferHistory(JSONObject json) {
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