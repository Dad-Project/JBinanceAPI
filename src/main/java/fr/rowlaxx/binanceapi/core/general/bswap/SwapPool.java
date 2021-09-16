package fr.rowlaxx.binanceapi.core.general.bswap;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.Set;

import org.json.JSONObject;

public class SwapPool extends JSavONObject {
	private static final long serialVersionUID = -8405819638278972559L;
	
	//Variables
	private Set<String> assets;
	private int poolId;
	private String poolName;
	
	//Constructeurs
	public SwapPool(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Set<String> getAssets() {
		return this.assets;
	}
	
	public final int getPoolId() {
		return this.poolId;
	}
	
	public final String getPoolName() {
		return this.poolName;
	}
}