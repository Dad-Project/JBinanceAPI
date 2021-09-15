package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.querysubaccountassets.Balances;

import java.util.List;

import org.json.JSONObject;

public class QuerySubaccountAssets extends JSavONObject {
	private static final long serialVersionUID = 3456440919156124204L;
	
	//Variables
	private List<Balances> balances;
	
	//Constructeurs
	public QuerySubaccountAssets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Balances> getBalances() {
		return this.balances;
	}
}