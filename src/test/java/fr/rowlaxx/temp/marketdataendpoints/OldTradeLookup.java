package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class OldTradeLookup extends JSavONObject {
	private static final long serialVersionUID = -5414825265717404855L;
	
	//Variables
	private int id;
	private boolean isBestMatch;
	private boolean isBuyerMaker;
	private double price;
	private double qty;
	private double quoteQty;
	private long time;
	
	//Constructeurs
	public OldTradeLookup(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getId() {
		return this.id;
	}
	
	public final boolean isBestMatch() {
		return this.isBestMatch;
	}
	
	public final boolean isBuyerMaker() {
		return this.isBuyerMaker;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final double getQuoteQty() {
		return this.quoteQty;
	}
	
	public final long getTime() {
		return this.time;
	}
}