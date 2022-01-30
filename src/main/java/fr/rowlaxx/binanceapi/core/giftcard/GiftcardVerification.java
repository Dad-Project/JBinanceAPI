package fr.rowlaxx.binanceapi.core.giftcard;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class GiftcardVerification extends JsavonObject {
	private static final long serialVersionUID = -4450603006762914883L;

	private String token;
	private double amount;
	private boolean valid;
	
	public GiftcardVerification(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getToken() {
		return token;
	}
	
	public final boolean isValid() {
		return valid;
	}
}
