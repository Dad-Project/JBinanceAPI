package fr.rowlaxx.temp.miningendpoints.earningslist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.earningslist.data.AccountProfits;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 1586551436458159839L;
	
	//Variables
	private List<AccountProfits> accountProfits;
	private int pageSize;
	private int totalNum;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<AccountProfits> getAccountProfits() {
		return this.accountProfits;
	}
	
	public final int getPageSize() {
		return this.pageSize;
	}
	
	public final int getTotalNum() {
		return this.totalNum;
	}
}