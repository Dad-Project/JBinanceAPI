package fr.rowlaxx.binanceapi;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class DepositAddress extends BinanceResponseJSON {
	@JsonValue private String address;
	@JsonValue private String tag;
	@JsonValue private String url;
	@JsonValue private String coin;

	public DepositAddress(JSONObject response) {
		super(response);
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getTag() {
		return tag;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getCoin() {
		return coin;
	}
}
