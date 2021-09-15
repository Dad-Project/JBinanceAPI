package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class DepositassetsintothemanagedsubaccountForInvestorMasterAccount extends JSavONObject {
	private static final long serialVersionUID = 3762569171664421692L;
	
	//Variables
	private long tranId;
	
	//Constructeurs
	public DepositassetsintothemanagedsubaccountForInvestorMasterAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTranId() {
		return this.tranId;
	}
}