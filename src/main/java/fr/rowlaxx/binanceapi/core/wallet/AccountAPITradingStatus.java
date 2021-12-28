package fr.rowlaxx.binanceapi.core.wallet;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class AccountAPITradingStatus extends JsavonObject {
	private static final long serialVersionUID = -5925716602971170802L;
	
	//Variables
	private boolean isLocked;
	private int plannedRecoverTime;
	private long updateTime;
	private Map<TriggerConditions, Integer> triggerCondition;
	
	@JOValue(mandatory = false)
	private Map<String, Indicators> indicators;

	//Constructeurs
	public AccountAPITradingStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, Indicators> getIndicators() {
		return this.indicators;
	}
	
	public final Indicators getIndicators(String symbol) {
		return this.indicators.get(symbol);
	}
	
	public final boolean isLocked() {
		return this.isLocked;
	}
	
	public final int getPlannedRecoverTime() {
		return this.plannedRecoverTime;
	}
	
	public final Map<TriggerConditions, Integer> getTriggerConditions() {
		return this.triggerCondition;
	}
	
	public final Integer getTriggerCondition(TriggerConditions conditions) {
		return this.triggerCondition.get(conditions);
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}