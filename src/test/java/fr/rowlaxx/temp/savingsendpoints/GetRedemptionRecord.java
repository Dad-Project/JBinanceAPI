package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetRedemptionRecord extends JSavONObject {
	private static final long serialVersionUID = 4143614253979861860L;
	
	//Variables
	private double amount;
	private String asset;
	private long createTime;
	private double principal;
	private String projectId;
	private String projectName;
	private String status;
	private String type;
	
	//Constructeurs
	public GetRedemptionRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final long getCreateTime() {
		return this.createTime;
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
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getType() {
		return this.type;
	}
}