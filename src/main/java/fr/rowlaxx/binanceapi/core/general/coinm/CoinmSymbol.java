package fr.rowlaxx.binanceapi.core.general.coinm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.future.FutureSymbol;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class CoinmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 4912543539944543970L;

	//Variables
	@JOValue private int equalQtyPrecision;
	@JOValue private int contractSize;
	@JOValue private int maxMoveOrderLimit;
	
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
