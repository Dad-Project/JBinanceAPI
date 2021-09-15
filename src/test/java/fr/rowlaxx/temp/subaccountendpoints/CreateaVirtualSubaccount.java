package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CreateaVirtualSubaccount extends JSavONObject {
	private static final long serialVersionUID = 3077318611015607873L;
	
	//Variables
	private String email;
	
	//Constructeurs
	public CreateaVirtualSubaccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
}