package fr.rowlaxx.binanceapi.core.staking;

import fr.rowlaxx.jsavon.JsavonObject;

public class StakingRecord extends JsavonObject {
	private static final long serialVersionUID = 7832697255871153941L;

	//Variables
	private int positionId;
	private long time;
	private String asset;
	private String project;
	private double amount;
	private int lockPeriod;
	private long deliverDate;
	private String type;
	private String status;
	
	//Getters
	public double getAmount() {
		return amount;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public long getDeliverDate() {
		return deliverDate;
	}
	
	public int getLockPeriod() {
		return lockPeriod;
	}
	
	public int getPositionId() {
		return positionId;
	}
	
	public String getProject() {
		return project;
	}
	
	public String getStatus() {
		return status;
	}
	
	public long getTime() {
		return time;
	}
	
	public String getType() {
		return type;
	}
}
