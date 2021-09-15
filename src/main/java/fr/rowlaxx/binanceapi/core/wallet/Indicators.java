package fr.rowlaxx.binanceapi.core.wallet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONArray;
import fr.rowlaxx.jsavon.annotations.ManualValue;

public class Indicators extends JSavONArray {
	private static final long serialVersionUID = 6299953810419276630L;

	//Variables
	@ManualValue
	private Map<TriggerConditions, Indicator> indicators;
	
	//Constructeurs
	public Indicators(JSONArray array) {
		super(array);
		final HashMap<TriggerConditions, Indicator> temp = new HashMap<>(3);
		Indicator indicator;
		for (Object object : array) {
			indicator = new Indicator((JSONObject)object);
			temp.put(indicator.getTriggerCondition(), indicator);
		}
		this.indicators = Collections.unmodifiableMap(temp);
	}
	
	//Getters
	public final Map<TriggerConditions, Indicator> get() {
		return this.indicators;
	}
	
	public final Indicator get(TriggerConditions triggerConditions) {
		return this.indicators.get(triggerConditions);
	}
	
	public final Indicator getUFR() {
		return get(TriggerConditions.UFR);
	}
	
	public final Indicator getIFER() {
		return get(TriggerConditions.IFER);
	}
	
	public final Indicator getGCR() {
		return get(TriggerConditions.GCR);
	}
}