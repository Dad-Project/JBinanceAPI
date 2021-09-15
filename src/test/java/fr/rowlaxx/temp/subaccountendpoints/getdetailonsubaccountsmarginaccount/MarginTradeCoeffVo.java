package fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsmarginaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MarginTradeCoeffVo extends JSavONObject {
	private static final long serialVersionUID = 7646092115694863338L;
	
	//Variables
	private double forceLiquidationBar;
	private double marginCallBar;
	private double normalBar;
	
	//Constructeurs
	public MarginTradeCoeffVo(JSONObject json) {
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