package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class RepayForCrossCollateral extends JSavONObject {
	private static final long serialVersionUID = 8493731377993148816L;
	
	//Variables
	private double amount;
	private String coin;
	private String collateralCoin;
	private long repayId;
	
	//Constructeurs
	public RepayForCrossCollateral(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final long getRepayId() {
		return this.repayId;
	}
}