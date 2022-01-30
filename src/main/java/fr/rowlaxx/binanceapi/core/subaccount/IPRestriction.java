package fr.rowlaxx.binanceapi.core.subaccount;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class IPRestriction extends JsavonObject {
	private static final long serialVersionUID = -6945097062179656566L;
	
	private boolean ipRestrict;
	@JOValue(mandatory = false) private List<String> ipList;
	private long updateTime;
	private String apiKey;
	
	public IPRestriction(JSONObject json) {
		super(json);
	}
	
	public final boolean ipRestrict() {
		return ipRestrict;
	}
	
	public final String getApiKey() {
		return apiKey;
	}
	
	public final List<String> getIpList() {
		return ipList;
	}
	
	public final long getUpdateTime() {
		return updateTime;
	}
	
}
