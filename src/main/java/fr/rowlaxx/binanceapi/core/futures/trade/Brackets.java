package fr.rowlaxx.binanceapi.core.futures.trade;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class Brackets extends JsavonObject {
	private static final long serialVersionUID = -7470467385858834850L;

	@JOValue(mandatory = false)
	private String symbol;
	@JOValue(mandatory = false)
	private String pair;
	
	private List<Bracket> brackets;
	
	public Brackets(JSONObject json) {
		super(json);
	}
	
	public String getPair() {
		return pair;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public List<Bracket> getBrackets() {
		return brackets;
	}
}
