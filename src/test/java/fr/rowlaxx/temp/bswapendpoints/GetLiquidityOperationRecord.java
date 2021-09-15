package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetLiquidityOperationRecord extends JSavONObject {
	private static final long serialVersionUID = -3599987839297542872L;
	
	//Variables
	private String operation;
	private int operationId;
	private int poolId;
	private String poolName;
	private double shareAmount;
	private int status;
	private long updateTime;
	
	//Constructeurs
	public GetLiquidityOperationRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getOperation() {
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
	
	public final int getStatus() {
		return this.status;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}