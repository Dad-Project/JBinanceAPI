package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class ClaimRecord extends JsavonObject {
	private static final long serialVersionUID = -1471380821308312579L;

	private int poolId;
	private String poolName;
	private String assetRewards;
	private long claimTime;
	private double claimAmount;
	private int status;
	
	public ClaimRecord(JSONObject json) {
		super(json);
	}
	
	public final String getAssetRewards() {
		return assetRewards;
	}
	
	public final double getClaimAmount() {
		return claimAmount;
	}
	
	public final long getClaimTime() {
		return claimTime;
	}
	
	public final int getPoolId() {
		return poolId;
	}
	
	public final String getPoolName() {
		return poolName;
	}
	
	public final int getStatus() {
		return status;
	}
}
