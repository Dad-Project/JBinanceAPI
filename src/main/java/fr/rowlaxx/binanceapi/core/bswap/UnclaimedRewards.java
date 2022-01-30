package fr.rowlaxx.binanceapi.core.bswap;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class UnclaimedRewards extends JsavonObject {
	private static final long serialVersionUID = 8157765997464193278L;

	private Map<String, Double> totalUnclaimedRewards;
	private Map<String, Map<String, Double>> details;
	
	public UnclaimedRewards(JSONObject json) {
		super(json);
	}
	
	public final Map<String, Map<String, Double>> getDetails() {
		return details;
	}
	
	public final Map<String, Double> getDetail(String poolName){
		return details.get(poolName);
	}
	
	public final Map<String, Double> getTotalUnclaimedRewards() {
		return totalUnclaimedRewards;
	}
	
	public final Double getTotalUnclaimedReward(String asset) {
		return totalUnclaimedRewards.get(asset);
	}
	
}
