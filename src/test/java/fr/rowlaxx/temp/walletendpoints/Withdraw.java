package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Withdraw extends JSavONObject {
	private static final long serialVersionUID = -4365549433652231153L;
	
	//Variables
	private String id;
	
	//Constructeurs
	public Withdraw(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getId() {
		return this.id;
	}
}