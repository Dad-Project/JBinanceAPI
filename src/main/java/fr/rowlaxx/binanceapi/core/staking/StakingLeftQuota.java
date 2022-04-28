package fr.rowlaxx.binanceapi.core.staking;

import fr.rowlaxx.jsavon.JsavonObject;

public class StakingLeftQuota extends JsavonObject {
	private static final long serialVersionUID = -7246180991171016058L;

	//Variables
	private double leftPersonalQuote;
	
	//Getters
	public double getLeftPersonalQuote() {
		return leftPersonalQuote;
	}
	
}
