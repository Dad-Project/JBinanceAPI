package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class AssetTransfer extends JsavonObject {
	private static final long serialVersionUID = 3120175490568947739L;
	
	//Variables
	private String asset;
	private String from;
	private int qty;
	private long time;
	private String to;
	private long tranId;
	@JOValue(mandatory = false)
	private TransferStatus status;
	
	//Constructeurs
	public AssetTransfer(JSONObject json) {
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
	
	public final TransferStatus getStatus() {
		return status;
	}
	
	public final String getTo() {
		return this.to;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
}