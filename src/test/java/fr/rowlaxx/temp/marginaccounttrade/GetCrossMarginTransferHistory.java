package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.getcrossmargintransferhistory.Rows;

import java.util.List;

import org.json.JSONObject;

public class GetCrossMarginTransferHistory extends JSavONObject {
	private static final long serialVersionUID = 1512772192227151211L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public GetCrossMarginTransferHistory(JSONObject json) {
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