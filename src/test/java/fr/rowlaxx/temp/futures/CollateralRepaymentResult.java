package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CollateralRepaymentResult extends JSavONObject {
	private static final long serialVersionUID = -7349490132901220724L;
	
	//Variables
	private String quoteId;
	private String status;
	
	//Constructeurs
	public CollateralRepaymentResult(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getQuoteId() {
		return this.quoteId;
	}
	
	public final String getStatus() {
		return this.status;
	}
}