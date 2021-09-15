package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class ListAllSwapPools extends JSavONObject {
	private static final long serialVersionUID = -8405819638278972559L;
	
	//Variables
	private List<String> assets;
	private int poolId;
	private String poolName;
	
	//Constructeurs
	public ListAllSwapPools(JSONObject json) {
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