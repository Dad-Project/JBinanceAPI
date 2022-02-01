package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class ADLQuantile extends JsavonObject {
	private static final long serialVersionUID = -8045773025829174231L;
	
	//Variables
	private String symbol;
	
	@JOValue(path = "adlQuantile", key = "LONG")
	private Integer LONG;
	@JOValue(path = "adlQuantile", key = "SHORT")
	private Integer SHORT;
	@JOValue(path = "adlQuantile", key = "BOTH", mandatory = false)
	private Integer BOTH;
	@JOValue(path = "adlQuantile", key = "HEDGE", mandatory = false)
	private Integer HEDGE;
	
	//Constructeurs
	public ADLQuantile(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Integer BOTH() {
		return BOTH;
	}
	
	public final Integer HEDGE() {
		return HEDGE;
	}
	
	public final Integer LONG() {
		return LONG;
	}
	
	public final Integer SHORT() {
		return SHORT;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}