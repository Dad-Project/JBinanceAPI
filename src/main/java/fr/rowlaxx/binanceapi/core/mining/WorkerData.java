package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class WorkerData extends JsavonObject {
	private static final long serialVersionUID = 3869847118376031611L;
	
	//Variables
	private int dayHashRate;
	private int hashRate;
	private long lastShareTime;
	private int rejectRate;
	private int status;
	private long workerId;
	private String workerName;
	
	//Constructeurs
	public WorkerData(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getDayHashRate() {
		return this.dayHashRate;
	}
	
	public final int getHashRate() {
		return this.hashRate;
	}
	
	public final long getLastShareTime() {
		return this.lastShareTime;
	}
	
	public final int getRejectRate() {
		return this.rejectRate;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final long getWorkerId() {
		return this.workerId;
	}
	
	public final String getWorkerName() {
		return this.workerName;
	}
}