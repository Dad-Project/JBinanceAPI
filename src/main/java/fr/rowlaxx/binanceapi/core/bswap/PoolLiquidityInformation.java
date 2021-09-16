package fr.rowlaxx.binanceapi.core.bswap;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class PoolLiquidityInformation extends JSavONObject {
private static final long serialVersionUID = 1035205055617813240L;
	
	//Variables
	private Map<String, Double> liquidity;
	private int poolId;
	private String poolNmae;
	private long updateTime;

	@JOValue(path = "share")
	private double shareAmount;
	@JOValue(path = "share")
	private double sharePercentage;
	@JOValue(path = "share")
	private Map<String, Double> asset;
	
	//Constructeurs
	public PoolLiquidityInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, Double> getLiquidity() {
		return this.liquidity;
	}
	
	public final int getPoolId() {
		return this.poolId;
	}
	
	public final String getPoolNmae() {
		return this.poolNmae;
	}
	
	public Map<String, Double> getAsset() {
		return this.asset;
	}
	
	public double getShareAmount() {
		return this.shareAmount;
	}
	
	public double getSharePercentage() {
		return this.sharePercentage;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}
