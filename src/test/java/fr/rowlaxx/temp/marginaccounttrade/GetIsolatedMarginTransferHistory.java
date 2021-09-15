package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.getisolatedmargintransferhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class GetIsolatedMarginTransferHistory extends JSavONObject {
	private static final long serialVersionUID = 8074644295187942524L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public GetIsolatedMarginTransferHistory(JSONObject json) {
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