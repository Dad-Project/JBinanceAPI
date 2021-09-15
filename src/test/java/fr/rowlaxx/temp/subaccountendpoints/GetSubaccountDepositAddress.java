package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetSubaccountDepositAddress extends JSavONObject {
	private static final long serialVersionUID = -301924051601520357L;
	
	//Variables
	private String address;
	private String coin;
	private String tag;
	private String url;
	
	//Constructeurs
	public GetSubaccountDepositAddress(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAddress() {
		return this.address;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getTag() {
		return this.tag;
	}
	
	public final String getUrl() {
		return this.url;
	}
}