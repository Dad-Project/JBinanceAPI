package fr.rowlaxx.binanceapi.core.api.bswap;

import java.util.regex.Matcher;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SwapPool extends BinanceResponseJSON {
	private static final long serialVersionUID = -3737165419471701335L;

	//Variables
	@JsonValue private String poolName;
	@JsonValue private long poolId;
	private final String firstAsset, secondAsset;
	
	//Constructeurs
	public SwapPool(JSONObject response) {
		super(response);
		final String[] temp = poolName.split(Matcher.quoteReplacement("/"));
		this.firstAsset = temp[0];
		this.secondAsset = temp[1];
	}
	
	//Getters
	public long getPoolId() {
		return poolId;
	}
	
	public String getPoolName() {
		return poolName;
	}
	
	public String getFirstAsset() {
		return firstAsset;
	}
	
	public String getSecondAsset() {
		return secondAsset;
	}
}