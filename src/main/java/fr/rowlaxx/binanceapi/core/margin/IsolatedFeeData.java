package fr.rowlaxx.binanceapi.core.margin;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.jsavon.JsavonObject;

public class IsolatedFeeData extends JsavonObject {
	private static final long serialVersionUID = 1295526319247086528L;

	private int vipLevel;
	private String symbol;
	private int leverage;
	@MapKey(fieldName = "coin") private Map<String, Fee> data;
	
	public IsolatedFeeData(JSONObject json) {
		super(json);
	}
	
	public final Map<String, Fee> getData() {
		return data;
	}
	
	public final int getLeverage() {
		return leverage;
	}
	
	public final String getSymbol() {
		return symbol;
	}
	
	public final int getVipLevel() {
		return vipLevel;
	}
}
