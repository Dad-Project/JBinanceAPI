package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.binanceapi.core.margin.CrossMarginTransferRecord;
import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class GetCrossMarginTransferHistory extends JSavONObject {
	private static final long serialVersionUID = 1512772192227151211L;
	
	//Variables
	private List<CrossMarginTransferRecord> rows;
	private int total;
	
	//Constructeurs
	public GetCrossMarginTransferHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<CrossMarginTransferRecord> getRows() {
		return this.rows;
	}
	
	public final int getTotal() {
		return this.total;
	}
}