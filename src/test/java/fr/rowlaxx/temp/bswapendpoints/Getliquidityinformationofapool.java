package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool.Liquidity;
import fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool.Share;

import org.json.JSONObject;

public class Getliquidityinformationofapool extends JSavONObject {
	private static final long serialVersionUID = 1035205055617813240L;
	
	//Variables
	private Liquidity liquidity;
	private int poolId;
	private String poolNmae;
	private Share share;
	private long updateTime;
	
	//Constructeurs
	public Getliquidityinformationofapool(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Liquidity getLiquidity() {
		return this.liquidity;
	}
	
	public final int getPoolId() {
		return this.poolId;
	}
	
	public final String getPoolNmae() {
		return this.poolNmae;
	}
	
	public final Share getShare() {
		return this.share;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}