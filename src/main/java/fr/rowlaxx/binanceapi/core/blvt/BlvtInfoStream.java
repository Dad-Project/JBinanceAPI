package fr.rowlaxx.binanceapi.core.blvt;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class BlvtInfoStream extends JsavonObject {
	private static final long serialVersionUID = 3106803357540629662L;

	//Variables
	@JOValue(key = "m")
	private double tokenIssued;
	@JOValue(key = "n")
	private double blvtNav;
	@JOValue(key = "l")
	private double realLeverage;
	@JOValue(key = "t")
	private double targetLeverage;
	@JOValue(key = "f")
	private double fundingRatio;
	@JOValue(key = "b")
	private List<BasketStream> baskets;
	
	
	public BlvtInfoStream(JSONObject json) {
		super(json);
	}
	
	public double getBlvtNav() {
		return blvtNav;
	}
	
	public double getFundingRatio() {
		return fundingRatio;
	}
	
	public double getRealLeverage() {
		return realLeverage;
	}
	
	public double getTargetLeverage() {
		return targetLeverage;
	}
	
	public double getTokenIssued() {
		return tokenIssued;
	}
	
	public List<BasketStream> getBaskets() {
		return baskets;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
