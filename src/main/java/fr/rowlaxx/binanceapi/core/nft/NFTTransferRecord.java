package fr.rowlaxx.binanceapi.core.nft;

import org.json.JSONObject;

public class NFTTransferRecord extends NFT {
	private static final long serialVersionUID = 4932200968346666228L;

	private long timestamp;
	private String txID;
	
	public NFTTransferRecord(JSONObject json) {
		super(json);
	}
	
	public final long getTimestamp() {
		return timestamp;
	}
	
	public final String getTxID() {
		return txID;
	}
}
