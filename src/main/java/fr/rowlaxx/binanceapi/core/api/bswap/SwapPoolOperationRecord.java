package fr.rowlaxx.binanceapi.core.api.bswap;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.enums.bswap.LiquidityOperation;
import fr.rowlaxx.binanceapi.enums.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SwapPoolOperationRecord extends SwapPool {
	private static final long serialVersionUID = 724599800562041993L;
	
	//Variables
	@JsonValue private long operationId;
	@JsonValue private LiquidityOperation operation;
	@JsonValue private LiquidityOperationStatus status;
	@JsonValue private long updateTime;
	@JsonValue private double shareAmount;
	
	//Constructeurs
	public SwapPoolOperationRecord(JSONObject response) {
		super(response);
	}
	
	//Getters
	public LiquidityOperation getOperation() {
		return operation;
	}
	
	public long getOperationId() {
		return operationId;
	}
	
	public double getShareAmount() {
		return shareAmount;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
	
	public LiquidityOperationStatus getStatus() {
		return status;
	}
}
