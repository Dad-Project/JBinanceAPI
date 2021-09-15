package fr.rowlaxx.temp.miningendpoints.extrabonuslist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.extrabonuslist.data.OtherProfits;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -2213515958754974328L;
	
	//Variables
	private List<OtherProfits> otherProfits;
	private int pageSize;
	private int totalNum;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<OtherProfits> getOtherProfits() {
		return this.otherProfits;
	}
	
	public final int getPageSize() {
		return this.pageSize;
	}
	
	public final int getTotalNum() {
		return this.totalNum;
	}
}