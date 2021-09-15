package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class WithdrawlassetsfromthemanagedsubaccountForInvestorMasterAccount extends JSavONObject {
	private static final long serialVersionUID = -2880446087345502277L;
	
	//Variables
	private long tranId;
	
	//Constructeurs
	public WithdrawlassetsfromthemanagedsubaccountForInvestorMasterAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTranId() {
		return this.tranId;
	}
}