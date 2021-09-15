package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class PurchaseFlexibleProduct extends JSavONObject {
	private static final long serialVersionUID = -4477481088051953090L;
	
	//Variables
	private int purchaseId;
	
	//Constructeurs
	public PurchaseFlexibleProduct(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getPurchaseId() {
		return this.purchaseId;
	}
}