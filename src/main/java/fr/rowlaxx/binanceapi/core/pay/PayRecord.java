package fr.rowlaxx.binanceapi.core.pay;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

public class PayRecord extends JsavonObject {
	private static final long serialVersionUID = -2584275802492516981L;

	private PayTypes orderType;
	private long transactionId;
	private long transactionTime;
	private double amount;
	private String currency;
	@MapKey(fieldName = "currency")
	private Map<String, Fund> fundsDetails;
	
	public PayRecord(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getCurrency() {
		return currency;
	}
	
	public final Map<String, Fund> getFunds() {
		return fundsDetails;
	}
	
	public final Fund getFund(String currency) {
		return fundsDetails.get(currency);
	}
	
	public final PayTypes getOrderType() {
		return orderType;
	}
	
	public final long getTransactionId() {
		return transactionId;
	}
	
	public final long getTransactionTime() {
		return transactionTime;
	}
	
}
