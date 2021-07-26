package fr.rowlaxx.binanceapi.core.api.bswap;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class DetailledSwapPool extends SwapPool {
	private static final long serialVersionUID = -8003281880884244932L;

	//Variables
	@JsonValue
	private long updateTime;
	
	@JsonValue(path = "share")
	private double shareAmount;
	
	@JsonValue(path = "share")
	private double sharePercentage;
	
	private final double firstAssetShare, secondAssetShare;
	private final double firstAssetLiquidity, secondAssetLiquidity;
	
	//Constructeurs
	public DetailledSwapPool(JSONObject response) {
		super(response);
		final JSONObject liquidity = response.getJSONObject("liquidity");
		this.firstAssetLiquidity = liquidity.getDouble(getFirstAsset());
		this.secondAssetLiquidity = liquidity.getDouble(getSecondAsset());
		final JSONObject asset = response.getJSONObject("share").getJSONObject("asset");
		this.firstAssetShare = asset.getDouble(getFirstAsset());
		this.secondAssetShare = asset.getDouble(getSecondAsset());
	}
	
	//Getters
	public double getShareAmount() {
		return shareAmount;
	}
	
	public double getSharePercentage() {
		return sharePercentage;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
	
	public double getFirstAssetLiquidity() {
		return firstAssetLiquidity;
	}
	
	public double getFirstAssetShare() {
		return firstAssetShare;
	}
	
	public double getSecondAssetLiquidity() {
		return secondAssetLiquidity;
	}
	
	public double getSecondAssetShare() {
		return secondAssetShare;
	}
}
