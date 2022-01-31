package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import fr.rowlaxx.binanceapi.core.futures.marketdata.OpenInterestStatistics;

import org.json.JSONObject;

public class CoinmOpenInterestStatistics extends OpenInterestStatistics {
	private static final long serialVersionUID = -5295606786464625449L;
	
	//Variables
	private String contractType;
	private String pair;
	
	//Constructeurs
	public CoinmOpenInterestStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getContractType() {
		return this.contractType;
	}
	
	public final String getPair() {
		return this.pair;
	}
}