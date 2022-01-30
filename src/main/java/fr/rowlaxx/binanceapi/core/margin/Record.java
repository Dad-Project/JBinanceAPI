package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class Record extends JsavonObject {
	private static final long serialVersionUID = -8784541029843999344L;
	
	private String asset;
	private String status;
	private long timestamp;
	private long txId;

	public Record(JSONObject json) {
		super(json);
	}

	public final String getAsset() {
		return this.asset;
	}

	public final String getStatus() {
		return this.status;
	}

	public final long getTimestamp() {
		return this.timestamp;
	}

	public final long getTxId() {
		return this.txId;
	}

}