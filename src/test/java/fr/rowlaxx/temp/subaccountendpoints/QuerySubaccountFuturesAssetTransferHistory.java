package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.querysubaccountfuturesassettransferhistory.Transfers;

import java.util.List;

import org.json.JSONObject;

public class QuerySubaccountFuturesAssetTransferHistory extends JSavONObject {
	private static final long serialVersionUID = -1236946185020639106L;
	
	//Variables
	private int futuresType;
	private boolean success;
	private List<Transfers> transfers;
	
	//Constructeurs
	public QuerySubaccountFuturesAssetTransferHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getFuturesType() {
		return this.futuresType;
	}
	
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final List<Transfers> getTransfers() {
		return this.transfers;
	}
}