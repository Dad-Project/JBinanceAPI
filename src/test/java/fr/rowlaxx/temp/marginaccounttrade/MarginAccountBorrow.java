package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MarginAccountBorrow extends JSavONObject {
	private static final long serialVersionUID = -675706543018387360L;
	
	//Variables
	private int tranId;
	
	//Constructeurs
	public MarginAccountBorrow(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTranId() {
		return this.tranId;
	}
}