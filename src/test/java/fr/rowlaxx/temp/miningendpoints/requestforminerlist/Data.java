package fr.rowlaxx.temp.miningendpoints.requestforminerlist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.requestforminerlist.data.WorkerDatas;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -5813972659560938424L;
	
	//Variables
	private int pageSize;
	private int totalNum;
	private List<WorkerDatas> workerDatas;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getPageSize() {
		return this.pageSize;
	}
	
	public final int getTotalNum() {
		return this.totalNum;
	}
	
	public final List<WorkerDatas> getWorkerDatas() {
		return this.workerDatas;
	}
}