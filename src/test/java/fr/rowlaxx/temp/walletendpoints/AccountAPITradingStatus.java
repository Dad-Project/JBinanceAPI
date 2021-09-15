package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.Data;

import org.json.JSONObject;

public class AccountAPITradingStatus extends JSavONObject {
	private static final long serialVersionUID = 6010691838779586483L;
	
	//Variables
	private Data data;
	
	//Constructeurs
	public AccountAPITradingStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Data getData() {
		return this.data;
	}
}