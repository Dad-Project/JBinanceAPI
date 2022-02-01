package fr.rowlaxx.binanceapi.core.usdm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.TriggerConditions;
import fr.rowlaxx.jsavon.JsavonObject;

public class UsdmIndicator extends JsavonObject {
	private static final long serialVersionUID = 983414546006114986L;

	private boolean isLocked;
	private long plannedRecoverTime;
	private TriggerConditions indicator;
	private double value;
	private double triggerValue;
	
	public UsdmIndicator(JSONObject json) {
		super(json);
	}
	
	public final boolean isLocked() {
		return isLocked;
	}
	
	public final TriggerConditions getIndicator() {
		return indicator;
	}
	
	public final long getPlannedRecoverTime() {
		return plannedRecoverTime;
	}
	
	public final double getTriggerValue() {
		return triggerValue;
	}
	
	public final double getValue() {
		return value;
	}
}
