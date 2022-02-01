package fr.rowlaxx.binanceapi.core.usdm.trade;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.TriggerConditions;
import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.ManualValue;

public class UsdmIndicators extends JsavonArray {
	private static final long serialVersionUID = 758433288816386279L;

	@ManualValue
	private final Map<TriggerConditions, UsdmIndicator> indicators;
	
	public UsdmIndicators(JSONArray json) {
		super(json);
		
		final HashMap<TriggerConditions, UsdmIndicator> map = new HashMap<>();
		UsdmIndicator indicator;
		for (Object o : json) {
			indicator = new UsdmIndicator( (JSONObject)o );
			map.put(indicator.getIndicator(), indicator);
		}
		
		this.indicators = Collections.unmodifiableMap(map);
	}
	
	public final Map<TriggerConditions, UsdmIndicator> getIndicators() {
		return indicators;
	}
	
	public final UsdmIndicator getUFR() {
		return indicators.get(TriggerConditions.UFR);
	}
	
	public final UsdmIndicator getIFER() {
		return indicators.get(TriggerConditions.IFER);
	}
	
	public final UsdmIndicator getDR() {
		return indicators.get(TriggerConditions.DR);
	}
	
	public final UsdmIndicator getGCR() {
		return indicators.get(TriggerConditions.GCR);
	}
}
