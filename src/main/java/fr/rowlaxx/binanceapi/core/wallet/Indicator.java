package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class Indicator extends JsavonObject {
	private static final long serialVersionUID = -855231720584463981L;
	
	//Variables
	@JOValue(key = "c")
	private int count;
	@JOValue(key = "i")
	private TriggerConditions triggerCondition;
	@JOValue(key = "t")
	private double triggerValue;
	@JOValue(key = "v")
	private double currentValue;
	
	//Constructeurs
	public Indicator(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCount() {
		return this.count;
	}
	
	public final double getCurrentValue() {
		return this.currentValue;
	}
	
	public final TriggerConditions getTriggerCondition() {
		return this.triggerCondition;
	}
	
	public final double getTriggerValue() {
		return this.triggerValue;
	}
}