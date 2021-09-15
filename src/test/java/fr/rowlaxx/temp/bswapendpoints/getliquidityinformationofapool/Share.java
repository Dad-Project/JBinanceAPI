package fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool.share.Asset;

import org.json.JSONObject;

public class Share extends JSavONObject {
	private static final long serialVersionUID = 1892178241769757734L;
	
	//Variables
	private Asset asset;
	private int shareAmount;
	private double sharePercentage;
	
	//Constructeurs
	public Share(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Asset getAsset() {
		return this.asset;
	}
	
	public final int getShareAmount() {
		return this.shareAmount;
	}
	
	public final double getSharePercentage() {
		return this.sharePercentage;
	}
}