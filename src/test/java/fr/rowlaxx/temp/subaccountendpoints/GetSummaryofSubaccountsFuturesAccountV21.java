package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv21.DeliveryAccountSummaryResp;

import org.json.JSONObject;

public class GetSummaryofSubaccountsFuturesAccountV21 extends JSavONObject {
	private static final long serialVersionUID = -5515108861029693154L;
	
	//Variables
	private DeliveryAccountSummaryResp deliveryAccountSummaryResp;
	
	//Constructeurs
	public GetSummaryofSubaccountsFuturesAccountV21(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final DeliveryAccountSummaryResp getDeliveryAccountSummaryResp() {
		return this.deliveryAccountSummaryResp;
	}
}