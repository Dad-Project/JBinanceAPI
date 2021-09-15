package fr.rowlaxx.binanceapi.core.order.spot;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Fill extends JSavONObject {
	private static final long serialVersionUID = 1049772128120402411L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private double price;
	private double qty;
	
	//Constructeurs
	public Fill(JSONObject json) {
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