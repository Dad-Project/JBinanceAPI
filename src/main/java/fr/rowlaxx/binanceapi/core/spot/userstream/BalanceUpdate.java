package fr.rowlaxx.binanceapi.core.spot.userstream;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class BalanceUpdate extends JsavonObject {
	private static final long serialVersionUID = -1280235801416007207L;

	//Variables
	@JOValue(key = "a")
	private String asset;
	@JOValue(key = "d")
	private double balanceDelta;
	@JOValue(key = "T")
	private long clearTime;
	
	//Getters
	public String getAsset() {
		return asset;
	}
	
	public double getBalanceDelta() {
		return balanceDelta;
	}
	
	public long getClearTime() {
		return clearTime;
	}
}
