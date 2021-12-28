package fr.rowlaxx.binanceapi.core.bswap;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class LiquidityOperationRecord extends JsavonObject {
	private static final long serialVersionUID = -3599987839297542872L;
	
	//Variables
	private LiquidityOperations operation;
	private int operationId;
	private int poolId;
	private String poolName;
	private double shareAmount;
	private LiquidityOperationStatus status;
	private long updateTime;
	
	//Constructeurs
	public LiquidityOperationRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final LiquidityOperations getOperation() {
		return this.operation;
	}
	
	public final int getOperationId() {
		return this.operationId;
	}
	
	public final int getPoolId() {
		return this.poolId;
	}
	
	public final String getPoolName() {
		return this.poolName;
	}
	
	public final double getShareAmount() {
		return this.shareAmount;
	}
	
	public final LiquidityOperationStatus getStatus() {
		return this.status;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}