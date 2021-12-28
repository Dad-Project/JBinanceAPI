package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class TriggerCondition extends JsavonObject {
	private static final long serialVersionUID = -2753940970920869578L;
	
	//Variables
	private int GCR;
	private int IFER;
	private int UFR;
	
	//Constructeurs
	public TriggerCondition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getGCR() {
		return this.GCR;
	}
	
	public final int getIFER() {
		return this.IFER;
	}
	
	public final int getUFR() {
		return this.UFR;
	}
}