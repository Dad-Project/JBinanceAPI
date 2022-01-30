package fr.rowlaxx.binanceapi.core.spot.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class AccountSnapshot extends JsavonObject {
	private static final long serialVersionUID = -6025630785683454849L;

	//Variables
	private AccountSnapshotTypes type;
	private long updateTime;
	
	//Constructeurs
	public AccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final AccountSnapshotTypes getType() {
		return this.type;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}
