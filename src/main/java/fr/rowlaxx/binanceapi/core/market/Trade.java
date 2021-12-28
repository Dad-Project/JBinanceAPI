package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public abstract class Trade extends JsavonObject {
	private static final long serialVersionUID = 3119645480784672286L;
	
	//Variables
	@JOValue(key = {"id", "a"})
	private int id;
	@JOValue(key = {"isBestMatch", "M"}, mandatory = false)
	private Boolean isBestMatch;
	@JOValue(key = {"price", "p"})
	private double price;
	@JOValue(key = {"qty", "q"})
	private double qty;
	@JOValue(key = {"time", "T"})
	private long time;
	
	//Constructeurs
	public Trade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getId() {
		return this.id;
	}
	
	public final Boolean isBestMatch() {
		return this.isBestMatch;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final long getTime() {
		return this.time;
	}
}