package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import java.util.List;

import org.json.JSONObject;

public class CompositeIndex extends JsavonObject {
	private static final long serialVersionUID = 3388436908607602299L;
	
	//Variables
	private List<BaseAsset> baseAssetList;
	private String component;
	private String symbol;
	private long time;
	
	//Constructeurs
	public CompositeIndex(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<BaseAsset> getBaseAssetList() {
		return this.baseAssetList;
	}
	
	public final String getComponent() {
		return this.component;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}