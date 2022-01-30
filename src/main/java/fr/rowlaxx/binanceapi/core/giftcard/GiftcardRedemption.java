package fr.rowlaxx.binanceapi.core.giftcard;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class GiftcardRedemption extends JsavonObject {
	private static final long serialVersionUID = -4450603006762914883L;

	private String token;
	private double amount;
	private long referenceNo;
	private long identityNo;
	
	public GiftcardRedemption(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final long getIdentityNo() {
		return identityNo;
	}
	
	public final long getReferenceNo() {
		return referenceNo;
	}
	
	public final String getToken() {
		return token;
	}
}
