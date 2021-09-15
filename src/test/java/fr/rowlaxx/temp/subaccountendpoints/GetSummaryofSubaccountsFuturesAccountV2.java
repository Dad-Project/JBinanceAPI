package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv2.FutureAccountSummaryResp;

import org.json.JSONObject;

public class GetSummaryofSubaccountsFuturesAccountV2 extends JSavONObject {
	private static final long serialVersionUID = 8063834489800726539L;
	
	//Variables
	private FutureAccountSummaryResp futureAccountSummaryResp;
	
	//Constructeurs
	public GetSummaryofSubaccountsFuturesAccountV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final FutureAccountSummaryResp getFutureAccountSummaryResp() {
		return this.futureAccountSummaryResp;
	}
}