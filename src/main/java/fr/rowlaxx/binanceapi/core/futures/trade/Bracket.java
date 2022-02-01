package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class Bracket extends JsavonObject {
	private static final long serialVersionUID = -6365191397695496821L;
	
	//Variables
	private int bracket;
	private int initialLeverage;
	private double maintMarginRatio;
	@JOValue(key = {"qtyCap","notionalCap"})
	private double cap;
	@JOValue(key = {"qtyFloor","notionalFloor"})
	private double floor;
	@JOValue(mandatory = false)
	private Integer cum;
	
	//Constructeurs
	public Bracket(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getBracket() {
		return this.bracket;
	}
	
	public final int getInitialLeverage() {
		return this.initialLeverage;
	}
	
	public final double getMaintMarginRatio() {
		return this.maintMarginRatio;
	}
	
	public final double getCap() {
		return cap;
	}
	
	public final Integer getCum() {
		return cum;
	}
	
	public final double getFloor() {
		return floor;
	}
}