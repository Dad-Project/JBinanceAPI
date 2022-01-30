package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

public class DustTransferRecord extends DustTransfer {
	private static final long serialVersionUID = -9212844790854835722L;

	//Variables
	private String clientId;
	private long transId;
	private long operateTime;
	
	//Constructeurs
	public DustTransferRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientId() {
		return this.clientId;
	}
	
	public final long getTransId() {
		return this.transId;
	}
	
	public final long getOperateTime() {
		return this.operateTime;
	}
}
