package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QuerySubaccountSpotAssetTransferHistory extends JSavONObject {
	private static final long serialVersionUID = 6193605946655989438L;
	
	//Variables
	private String asset;
	private String from;
	private int qty;
	private String status;
	private long time;
	private String to;
	private long tranId;
	
	//Constructeurs
	public QuerySubaccountSpotAssetTransferHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getFrom() {
		return this.from;
	}
	
	public final int getQty() {
		return this.qty;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final String getTo() {
		return this.to;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
}