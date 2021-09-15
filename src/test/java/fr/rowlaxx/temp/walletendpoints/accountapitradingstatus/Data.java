package fr.rowlaxx.temp.walletendpoints.accountapitradingstatus;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.Indicators;
import fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.TriggerCondition;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -5925716602971170802L;
	
	//Variables
	private Indicators indicators;
	private boolean isLocked;
	private int plannedRecoverTime;
	private TriggerCondition triggerCondition;
	private long updateTime;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Indicators getIndicators() {
		return this.indicators;
	}
	
	public final boolean isLocked() {
		return this.isLocked;
	}
	
	public final int getPlannedRecoverTime() {
		return this.plannedRecoverTime;
	}
	
	public final TriggerCondition getTriggerCondition() {
		return this.triggerCondition;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}