package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CrossMarginAccountTransfer extends JSavONObject {
	private static final long serialVersionUID = 396815098867291512L;
	
	//Variables
	private int tranId;
	
	//Constructeurs
	public CrossMarginAccountTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTranId() {
		return this.tranId;
	}
}