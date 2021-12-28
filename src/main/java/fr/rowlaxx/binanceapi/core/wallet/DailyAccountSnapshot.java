package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class DailyAccountSnapshot extends JsavonObject {
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
