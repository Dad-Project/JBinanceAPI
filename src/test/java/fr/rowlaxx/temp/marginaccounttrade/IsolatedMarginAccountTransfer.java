package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class IsolatedMarginAccountTransfer extends JSavONObject {
	private static final long serialVersionUID = -6997953710676329742L;
	
	//Variables
	private int tranId;
	
	//Constructeurs
	public IsolatedMarginAccountTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTranId() {
		return this.tranId;
	}
}