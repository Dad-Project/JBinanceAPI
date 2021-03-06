package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.FutureSymbol;

public class CoinmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 4912543539944543970L;

	//Variables
	private int equalQtyPrecision;
	private int contractSize;
	private int maxMoveOrderLimit;
	
	//Constructeurs
	public CoinmSymbol(JSONObject response) {
		super(response);
	}

	//Getters
	public int getEqualQtyPrecision() {
		return equalQtyPrecision;
	}

	public int getContractSize() {
		return contractSize;
	}

	public int getMaxMoveOrderLimit() {
		return maxMoveOrderLimit;
	}
}
