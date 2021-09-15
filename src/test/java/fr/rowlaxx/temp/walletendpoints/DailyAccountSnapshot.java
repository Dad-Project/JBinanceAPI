package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot.SnapshotVos;

import java.util.List;

import org.json.JSONObject;

public class DailyAccountSnapshot extends JSavONObject {
	private static final long serialVersionUID = 3660775116364528028L;
	
	//Variables
	private int code;
	private String msg;
	private List<SnapshotVos> snapshotVos;
	
	//Constructeurs
	public DailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final String getMsg() {
		return this.msg;
	}
	
	public final List<SnapshotVos> getSnapshotVos() {
		return this.snapshotVos;
	}
}