package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.binanceapi.core.futures.marketdata.OpenInterest;

import org.json.JSONObject;

public class CoinmOpenInterest extends OpenInterest {
	private static final long serialVersionUID = -2417820515204406384L;
	
	//Variables
	private ContractTypes contractType;
	private String pair;
	
	//Constructeurs
	public CoinmOpenInterest(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final ContractTypes getContractType() {
		return this.contractType;
	}
	
	public final String getPair() {
		return this.pair;
	}
}