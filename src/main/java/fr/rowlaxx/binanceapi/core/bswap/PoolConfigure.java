package fr.rowlaxx.binanceapi.core.bswap;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class PoolConfigure extends JsavonObject {
	private static final long serialVersionUID = 6056615331216757549L;
	
	//Variables
	private int poolId;
	private String poolName;
	private long updateTime;
	@JOValue(path = "liquidity")
	private double constantA, minRedeemShare, slippageTolerance;
	private Map<String, AssetConfigure> assetConfigure;
	
	//Constructeurs
	public PoolConfigure(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getConstantA() {
		return constantA;
	}
	
	public final double getMinRedeemShare() {
		return minRedeemShare;
	}
	
	public final int getPoolId() {
		return poolId;
	}
	
	public final String getPoolName() {
		return poolName;
	}
	
	public final double getSlippageTolerance() {
		return slippageTolerance;
	}
	
	public final long getUpdateTime() {
		return updateTime;
	}
	
	public Map<String, AssetConfigure> getAssetConfigures() {
		return assetConfigure;
	}
	
	public final AssetConfigure getAssetConfigure(String asset) {
		return assetConfigure.get(asset);
	}
}
