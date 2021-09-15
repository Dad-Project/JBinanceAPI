package fr.rowlaxx.temp.miningendpoints.requestfordetailminerlist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.requestfordetailminerlist.data.HashrateDatas;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 8342586463776910307L;
	
	//Variables
	private List<HashrateDatas> hashrateDatas;
	private String type;
	private String workerName;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<HashrateDatas> getHashrateDatas() {
		return this.hashrateDatas;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final String getWorkerName() {
		return this.workerName;
	}
}