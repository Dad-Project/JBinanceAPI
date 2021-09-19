package fr.rowlaxx.binanceapi.core.mining;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class MinerDetail extends JSavONObject {
	private static final long serialVersionUID = 8342586463776910307L;
	
	//Variables
	private List<HashrateData> hashrateDatas;
	private String type;
	private String workerName;
	
	//Constructeurs
	public MinerDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<HashrateData> getHashrateDatas() {
		return this.hashrateDatas;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final String getWorkerName() {
		return this.workerName;
	}
}