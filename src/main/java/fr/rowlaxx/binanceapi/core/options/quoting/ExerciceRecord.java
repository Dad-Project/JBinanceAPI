package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class ExerciceRecord extends JsavonObject {
	private static final long serialVersionUID = -5634367769496203721L;

	private String symbol;
	private double strikePrice;
	private double realStrikePrice;
	private long expiryDate;
	private String strikeResult;
	
	public ExerciceRecord(JSONObject json) {
		super(json);
	}
	
	public final long getExpiryDate() {
		return expiryDate;
	}
	
	public final double getRealStrikePrice() {
		return realStrikePrice;
	}
	
	public final double getStrikePrice() {
		return strikePrice;
	}
	
	public final String getStrikeResult() {
		return strikeResult;
	}
	
	public final String getSymbol() {
		return symbol;
	}
}
