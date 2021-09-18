package fr.rowlaxx.binanceapi.core.future;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CollateralRepayLimit extends JSavONObject {
	private static final long serialVersionUID = -3991816538323425562L;
	
	//Variables
	private String coin;
	private String collateralCoin;
	private int max;
	private int min;
	
	//Constructeurs
	public CollateralRepayLimit(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final int getMax() {
		return this.max;
	}
	
	public final int getMin() {
		return this.min;
	}
}