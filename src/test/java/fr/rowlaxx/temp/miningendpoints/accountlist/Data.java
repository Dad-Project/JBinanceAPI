package fr.rowlaxx.temp.miningendpoints.accountlist;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.accountlist.data.List;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -2423280816656980988L;
	
	//Variables
	private List<List> list;
	private String type;
	private String userName;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<List> getList() {
		return this.list;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final String getUserName() {
		return this.userName;
	}
}