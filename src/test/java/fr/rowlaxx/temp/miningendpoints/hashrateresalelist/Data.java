package fr.rowlaxx.temp.miningendpoints.hashrateresalelist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.hashrateresalelist.data.ConfigDetails;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 5055367798328602912L;
	
	//Variables
	private List<ConfigDetails> configDetails;
	private int pageSize;
	private int totalNum;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<ConfigDetails> getConfigDetails() {
		return this.configDetails;
	}
	
	public final int getPageSize() {
		return this.pageSize;
	}
	
	public final int getTotalNum() {
		return this.totalNum;
	}
}