package fr.rowlaxx.binanceapi.core.mining;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class UserStatistics extends JsavonObject {
	private static final long serialVersionUID = -2423280816656980988L;
	
	//Variables
	private List<UserStatisticsRecord> list;
	private String type;
	private String userName;
	
	//Constructeurs
	public UserStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<UserStatisticsRecord> getList() {
		return this.list;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final String getUserName() {
		return this.userName;
	}
}