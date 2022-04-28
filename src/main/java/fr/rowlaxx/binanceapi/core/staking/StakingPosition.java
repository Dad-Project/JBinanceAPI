package fr.rowlaxx.binanceapi.core.staking;

import fr.rowlaxx.jsavon.JsavonObject;

public class StakingPosition extends JsavonObject {
	private static final long serialVersionUID = -5268023992965764730L;

	//Variables
	private long positionId;
	private String projectId;
	private String asset;
	private double amount;
	private long purchaseTime;
	private int duration;
	private int accrualDays;
	private String rewardAsset;
	private double APY;
	private double rewardAmt;
	private String extraRewardAsset;
	private double extraRewardAPY;
	private double estExtraRewardAmt;
	private double nextInterestPay;
	private long nextInterestPayDate;
	private int payInterestPeriod;
	private double redeemAmountEarly;
	private long interestEndDate;
	private long deliverDate;
	private int redeemPeriod;
	private double redeemingAmt;
	private long partialAmtDeliverDate;
	private boolean canRedeemEarly;
	private boolean renewable;
	private String type;
	private String status;
	
	//Getters
	public int getAccrualDays() {
		return accrualDays;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getAPY() {
		return APY;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public long getDeliverDate() {
		return deliverDate;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getEstExtraRewardAmt() {
		return estExtraRewardAmt;
	}
	
	public double getExtraRewardAPY() {
		return extraRewardAPY;
	}
	
	public String getExtraRewardAsset() {
		return extraRewardAsset;
	}
	
	public long getInterestEndDate() {
		return interestEndDate;
	}
	
	public double getNextInterestPay() {
		return nextInterestPay;
	}
	
	public long getNextInterestPayDate() {
		return nextInterestPayDate;
	}
	
	public long getPartialAmtDeliverDate() {
		return partialAmtDeliverDate;
	}
	
	public int getPayInterestPeriod() {
		return payInterestPeriod;
	}
	
	public long getPositionId() {
		return positionId;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public long getPurchaseTime() {
		return purchaseTime;
	}
	
	public double getRedeemAmountEarly() {
		return redeemAmountEarly;
	}
	
	public double getRedeemingAmt() {
		return redeemingAmt;
	}
	
	public int getRedeemPeriod() {
		return redeemPeriod;
	}
	
	public double getRewardAmt() {
		return rewardAmt;
	}
	
	public String getRewardAsset() {
		return rewardAsset;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean canRedeemEarly() {
		return canRedeemEarly;
	}
	
	public boolean isRenewable() {
		return renewable;
	}
}
