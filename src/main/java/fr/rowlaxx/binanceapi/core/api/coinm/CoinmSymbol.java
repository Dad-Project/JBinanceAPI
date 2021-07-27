package fr.rowlaxx.binanceapi.core.api.coinm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.future.ContractStatus;
import fr.rowlaxx.binanceapi.core.future.FutureSymbol;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class CoinmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 4912543539944543970L;

	//Variables
	@JsonValue private int equalQtyPrecision;
	@JsonValue private int contractSize;
	@JsonValue private int maxMoveOrderLimit;
	@JsonValue private int baseAssetPrecision;
	@JsonValue private ContractStatus contractStatus;
	
	//Constructeurs
	public CoinmSymbol(JSONObject response) {
		super(response);
	}

	//Getters
	public ContractStatus getContractStatus() {
		return contractStatus;
	}
	
	public int getEqualQtyPrecision() {
		return equalQtyPrecision;
	}

	public int getContractSize() {
		return contractSize;
	}

	public int getMaxMoveOrderLimit() {
		return maxMoveOrderLimit;
	}

	public int getBaseAssetPrecision() {
		return baseAssetPrecision;
	}
}
