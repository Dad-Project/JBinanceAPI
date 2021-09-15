package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class PurchaseFixedActivityProject extends JSavONObject {
	private static final long serialVersionUID = -5781465420774880319L;
	
	//Variables
	private int purchaseId;
	
	//Constructeurs
	public PurchaseFixedActivityProject(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getPurchaseId() {
		return this.purchaseId;
	}
}