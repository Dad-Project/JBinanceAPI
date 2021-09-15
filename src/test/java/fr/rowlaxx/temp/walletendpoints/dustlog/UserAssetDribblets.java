package fr.rowlaxx.temp.walletendpoints.dustlog;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dustlog.userassetdribblets.UserAssetDribbletDetails;

import java.util.List;

import org.json.JSONObject;

public class UserAssetDribblets extends JSavONObject {
	private static final long serialVersionUID = -7498199469499039483L;
	
	//Variables
	private long operateTime;
	private double totalServiceChargeAmount;
	private double totalTransferedAmount;
	private long transId;
	private List<UserAssetDribbletDetails> userAssetDribbletDetails;
	
	//Constructeurs
	public UserAssetDribblets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getOperateTime() {
		return this.operateTime;
	}
	
	public final double getTotalServiceChargeAmount() {
		return this.totalServiceChargeAmount;
	}
	
	public final double getTotalTransferedAmount() {
		return this.totalTransferedAmount;
	}
	
	public final long getTransId() {
		return this.transId;
	}
	
	public final List<UserAssetDribbletDetails> getUserAssetDribbletDetails() {
		return this.userAssetDribbletDetails;
	}
}