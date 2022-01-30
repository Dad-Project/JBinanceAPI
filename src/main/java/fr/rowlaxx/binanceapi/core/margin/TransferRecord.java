package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public abstract class TransferRecord extends Record {
	private static final long serialVersionUID = 4974505064584104434L;
	
	//Variables
	private double amount;

	//Constructeurs
	public TransferRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
}