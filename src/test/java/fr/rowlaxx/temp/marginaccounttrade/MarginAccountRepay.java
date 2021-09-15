package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MarginAccountRepay extends JSavONObject {
	private static final long serialVersionUID = 3228068696639032987L;
	
	//Variables
	private int tranId;
	
	//Constructeurs
	public MarginAccountRepay(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTranId() {
		return this.tranId;
	}
}