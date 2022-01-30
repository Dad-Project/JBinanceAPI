package fr.rowlaxx.binanceapi.core.giftcard;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Giftcard extends JsavonObject {
	private static final long serialVersionUID = -3653444793130782363L;

	private String code;
	private long referenceNo;
	
	public Giftcard(JSONObject json) {
		super(json);
	}
	
	public final String getCode() {
		return code;
	}
	
	public final long getReferenceNo() {
		return referenceNo;
	}
	
}
