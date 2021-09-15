package fr.rowlaxx.temp.subaccountendpoints.querysubaccountfuturesassettransferhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Transfers extends JSavONObject {
	private static final long serialVersionUID = 3120175490568947739L;
	
	//Variables
	private String asset;
	private String from;
	private int qty;
	private long time;
	private String to;
	private long tranId;
	
	//Constructeurs
	public Transfers(JSONObject json) {
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