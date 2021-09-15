package fr.rowlaxx.temp.marginaccounttrade.marginaccountneworder2;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Fills extends JSavONObject {
	private static final long serialVersionUID = -691445146696545826L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private double price;
	private double qty;
	
	//Constructeurs
	public Fills(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getCommission() {
		return this.commission;
	}
	
	public final String getCommissionAsset() {
		return this.commissionAsset;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
}