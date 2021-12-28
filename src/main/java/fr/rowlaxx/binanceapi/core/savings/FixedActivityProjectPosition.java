package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FixedActivityProjectPosition extends JsavonObject {
	private static final long serialVersionUID = -2942824935271249869L;
	
	//Variables
	private String asset;
	private boolean canTransfer;
	private long createTimestamp;
	private int duration;
	private long endTime;
	private double interest;
	private double interestRate;
	private int lot;
	private int positionId;
	private double principal;
	private String projectId;
	private String projectName;
	private long purchaseTime;
	private String redeemDate;
	private long startTime;
	private String status;
	private String type;
	
	//Constructeurs
	public FixedActivityProjectPosition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final boolean isCanTransfer() {
		return this.canTransfer;
	}
	
	public final long getCreateTimestamp() {
		return this.createTimestamp;
	}
	
	public final int getDuration() {
		return this.duration;
	}
	
	public final long getEndTime() {
		return this.endTime;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final int getLot() {
		return this.lot;
	}
	
	public final int getPositionId() {
		return this.positionId;
	}
	
	public final double getPrincipal() {
		return this.principal;
	}
	
	public final String getProjectId() {
		return this.projectId;
	}
	
	public final String getProjectName() {
		return this.projectName;
	}
	
	public final long getPurchaseTime() {
		return this.purchaseTime;
	}
	
	public final String getRedeemDate() {
		return this.redeemDate;
	}
	
	public final long getStartTime() {
		return this.startTime;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getType() {
		return this.type;
	}
}