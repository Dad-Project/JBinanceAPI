package fr.rowlaxx.binanceapi.core.bswap;

import fr.rowlaxx.jsavon.JsavonObject;

import java.util.List;

import org.json.JSONObject;

public class SwapPool extends JsavonObject {
	private static final long serialVersionUID = -8405819638278972559L;
	
	//Variables
	private List<String> assets;
	private int poolId;
	private String poolName;
	
	//Constructeurs
	public SwapPool(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<String> getAssets() {
		return this.assets;
	}
	
	public final int getPoolId() {
		return this.poolId;
	}
	
	public final String getPoolName() {
		return this.poolName;
	}
}