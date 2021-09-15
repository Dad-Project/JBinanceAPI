package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.querysubaccountlist.SubAccounts;

import java.util.List;

import org.json.JSONObject;

public class QuerySubaccountList extends JSavONObject {
	private static final long serialVersionUID = -4086878551726703020L;
	
	//Variables
	private List<SubAccounts> subAccounts;
	
	//Constructeurs
	public QuerySubaccountList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<SubAccounts> getSubAccounts() {
		return this.subAccounts;
	}
}