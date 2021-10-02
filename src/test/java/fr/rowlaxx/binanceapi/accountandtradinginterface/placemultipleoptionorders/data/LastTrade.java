package fr.rowlaxx.temp.accountandtradinginterface.placemultipleoptionorders.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class LastTrade extends JSavONObject {
	private static final long serialVersionUID = 1274758806112877615L;
	
	//Variables
	private int id;
	private int price;
	private double qty;
	private long time;
	
	//Constructeurs
	public LastTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getId() {
		return this.id;
	}
	
	public final int getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final long getTime() {
		return this.time;
	}
}