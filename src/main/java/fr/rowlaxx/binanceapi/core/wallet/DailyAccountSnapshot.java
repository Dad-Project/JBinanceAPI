package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;

public abstract class DailyAccountSnapshot extends JSavONObject {
	private static final long serialVersionUID = -6025630785683454849L;

	//Variables
	private DailyAccountSnapshotTypes type;
	private long updateTime;
	
	//Constructeurs
	public DailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final DailyAccountSnapshotTypes getType() {
		return this.type;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}
