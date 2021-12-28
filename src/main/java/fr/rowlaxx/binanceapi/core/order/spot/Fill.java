package fr.rowlaxx.binanceapi.core.order.spot;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Fill extends JsavonObject {
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