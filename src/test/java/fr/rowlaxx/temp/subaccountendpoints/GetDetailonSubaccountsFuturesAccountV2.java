package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv2.FutureAccountResp;

import org.json.JSONObject;

public class GetDetailonSubaccountsFuturesAccountV2 extends JSavONObject {
	private static final long serialVersionUID = -421666664875868267L;
	
	//Variables
	private FutureAccountResp futureAccountResp;
	
	//Constructeurs
	public GetDetailonSubaccountsFuturesAccountV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final FutureAccountResp getFutureAccountResp() {
		return this.futureAccountResp;
	}
}