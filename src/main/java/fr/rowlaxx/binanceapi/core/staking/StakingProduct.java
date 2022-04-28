package fr.rowlaxx.binanceapi.core.staking;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class StakingProduct extends JsavonObject {
	private static final long serialVersionUID = 1779196577318668522L;

	//Variables
	private String projectId;
	@JOValue(path = "detail") private String asset;
	@JOValue(path = "detail") private String rewardAsset;
	@JOValue(path = "detail") private int duration;
	@JOValue(path = "detail") private boolean renewable;
	@JOValue(path = "detail") private double apy;
	@JOValue(path = "quota") private double minimum;
	@JOValue(path = "quota") private double totalPersonalQuota;

	//Getters
	public double getApy() {
		return apy;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getMinimum() {
		return minimum;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public String getRewardAsset() {
		return rewardAsset;
	}
	
	public double getTotalPersonalQuota() {
		return totalPersonalQuota;
	}
}
