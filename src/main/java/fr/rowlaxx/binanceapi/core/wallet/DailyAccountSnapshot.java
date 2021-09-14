package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class DailyAccountSnapshot extends JSavONObject {
	private static final long serialVersionUID = -6025630785683454849L;

	//Variables
	@JOValue private DailyAccountSnapshotTypes type;
	@JOValue private long updateTime;
	
	//Constructeurs
	public DailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public DailyAccountSnapshotTypes getType() {
		return type;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
}
