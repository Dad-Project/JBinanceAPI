package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class MarginCoeffVo extends JsavonObject {
	private static final long serialVersionUID = 7646092115694863338L;
	
	//Variables
	private double forceLiquidationBar;
	private double marginCallBar;
	private double normalBar;
	
	//Constructeurs
	public MarginCoeffVo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getForceLiquidationBar() {
		return this.forceLiquidationBar;
	}
	
	public final double getMarginCallBar() {
		return this.marginCallBar;
	}
	
	public final double getNormalBar() {
		return this.normalBar;
	}
}