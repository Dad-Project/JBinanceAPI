package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryMaxTransferOutAmount extends JSavONObject {
	private static final long serialVersionUID = -7237843651635734378L;
	
	//Variables
	private double amount;
	
	//Constructeurs
	public QueryMaxTransferOutAmount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
}