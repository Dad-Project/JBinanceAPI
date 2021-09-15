package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv21.DeliveryAccountResp;

import org.json.JSONObject;

public class GetDetailonSubaccountsFuturesAccountV21 extends JSavONObject {
	private static final long serialVersionUID = 1145784580638515982L;
	
	//Variables
	private DeliveryAccountResp deliveryAccountResp;
	
	//Constructeurs
	public GetDetailonSubaccountsFuturesAccountV21(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final DeliveryAccountResp getDeliveryAccountResp() {
		return this.deliveryAccountResp;
	}
}