package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class RedemptionRecord extends JsavonObject {
	private static final long serialVersionUID = 4143614253979861860L;
	
	//Variables
	private double amount;
	private String asset;
	@JOValue(mandatory = false)
	private Double interest;
	private long createTime;
	private double principal;
	private String projectId;
	private String projectName;
	private String status;
	@JOValue(mandatory = false)
	private String type;
	@JOValue(mandatory = false)
	private Double startTime;
	
	//Constructeurs
	public RedemptionRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final Double getInterest() {
		return interest;
	}
	
	public final Double getStartTime() {
		return startTime;
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