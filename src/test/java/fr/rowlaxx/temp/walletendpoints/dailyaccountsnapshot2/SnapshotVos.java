package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos.Data;

import org.json.JSONObject;

public class SnapshotVos extends JSavONObject {
	private static final long serialVersionUID = -2826000968132576623L;
	
	//Variables
	private Data data;
	private String type;
	private long updateTime;
	
	//Constructeurs
	public SnapshotVos(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Data getData() {
		return this.data;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}