package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.SnapshotVos;

import java.util.List;

import org.json.JSONObject;

public class DailyAccountSnapshot2 extends JSavONObject {
	private static final long serialVersionUID = -2513116493094886720L;
	
	//Variables
	private int code;
	private String msg;
	private List<SnapshotVos> snapshotVos;
	
	//Constructeurs
	public DailyAccountSnapshot2(JSONObject json) {
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