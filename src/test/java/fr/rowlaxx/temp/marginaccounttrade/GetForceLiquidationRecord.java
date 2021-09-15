package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.getforceliquidationrecord.Rows;

import java.util.List;

import org.json.JSONObject;

public class GetForceLiquidationRecord extends JSavONObject {
	private static final long serialVersionUID = -1138241177869200115L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public GetForceLiquidationRecord(JSONObject json) {
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