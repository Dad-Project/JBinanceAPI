package fr.rowlaxx.binanceapi.core.fiat;

import org.json.JSONObject;

public class FiatTransferRecord extends FiatTransfer {
	private static final long serialVersionUID = 7805426192193016213L;
	
	//Variables
	private double amount;
	private double indicatedAmount;
	private String method;
	
	//Constructeurs
	public FiatTransferRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getIndicatedAmount() {
		return this.indicatedAmount;
	}
	
	public final String getMethod() {
		return this.method;
	}
}