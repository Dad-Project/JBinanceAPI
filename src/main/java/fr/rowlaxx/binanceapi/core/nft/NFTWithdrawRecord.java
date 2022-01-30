package fr.rowlaxx.binanceapi.core.nft;

import org.json.JSONObject;

public class NFTWithdrawRecord extends NFTTransferRecord {
	private static final long serialVersionUID = 7268836427985670277L;

	private double fee;
	private String feeAsset;
	
	public NFTWithdrawRecord(JSONObject json) {
		super(json);
	}
	
	public final double getFee() {
		return fee;
	}
	
	public final String getFeeAsset() {
		return feeAsset;
	}
}
