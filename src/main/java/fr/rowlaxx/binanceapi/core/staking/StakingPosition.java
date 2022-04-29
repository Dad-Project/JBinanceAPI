package fr.rowlaxx.binanceapi.core.staking;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class StakingPosition extends JsavonObject {
	private static final long serialVersionUID = -5268023992965764730L;

	//Variables
	private long positionId;
	@JOValue(mandatory = false) private String projectId;
	private String asset;
	private double amount;
	private long purchaseTime;
	private int duration;
	private int accrualDays;
	private String rewardAsset;
	private double apy;
	private double rewardAmt;
	@JOValue(mandatory = false) private String extraRewardAsset;
	@JOValue(mandatory = false) private Double extraRewardAPY;
	@JOValue(mandatory = false) private Double estExtraRewardAmt;
	@JOValue(mandatory = false) private Double nextInterestPay;
	@JOValue(mandatory = false) private Long nextInterestPayDate;
	private int payInterestPeriod;
	private double redeemAmountEarly;
	private long interestEndDate;
	private long deliverDate;
	private int redeemPeriod;
	@JOValue(mandatory = false) private Double redeemingAmt;
	@JOValue(mandatory = false) private Long partialAmtDeliverDate;
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
	
	public double getApy() {
		return apy;
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
	
	public Double getEstExtraRewardAmt() {
		return estExtraRewardAmt;
	}
	
	public Double getExtraRewardAPY() {
		return extraRewardAPY;
	}
	
	public String getExtraRewardAsset() {
		return extraRewardAsset;
	}
	
	public long getInterestEndDate() {
		return interestEndDate;
	}
	
	public Double getNextInterestPay() {
		return nextInterestPay;
	}
	
	public Long getNextInterestPayDate() {
		return nextInterestPayDate;
	}
	
	public Long getPartialAmtDeliverDate() {
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
	
	public Double getRedeemingAmt() {
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
