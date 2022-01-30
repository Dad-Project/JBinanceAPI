package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FixedProduct extends JsavonObject {
	private static final long serialVersionUID = -1313239728536683667L;
	
	//Variables
	private String asset;
	private int displayPriority;
	private int duration;
	private double interestPerLot;
	private double interestRate;
	private double lotSize;
	private int lotsLowLimit;
	private int lotsPurchased;
	private int lotsUpLimit;
	private int maxLotsPerUser;
	private boolean needKyc;
	private String projectId;
	private String projectName;
	private String status;
	private String type;
	private boolean withAreaLimitation;
	
	//Constructeurs
	public FixedProduct(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final int getDisplayPriority() {
		return this.displayPriority;
	}
	
	public final int getDuration() {
		return this.duration;
	}
	
	public final double getInterestPerLot() {
		return this.interestPerLot;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final double getLotSize() {
		return this.lotSize;
	}
	
	public final int getLotsLowLimit() {
		return this.lotsLowLimit;
	}
	
	public final int getLotsPurchased() {
		return this.lotsPurchased;
	}
	
	public final int getLotsUpLimit() {
		return this.lotsUpLimit;
	}
	
	public final int getMaxLotsPerUser() {
		return this.maxLotsPerUser;
	}
	
	public final boolean isNeedKyc() {
		return this.needKyc;
	}
	
	public final String getProjectId() {
		return this.projectId;
	}
	
	public final String getProjectName() {
		return this.projectName;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final boolean isWithAreaLimitation() {
		return this.withAreaLimitation;
	}
}