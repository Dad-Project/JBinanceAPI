package fr.rowlaxx.temp.futures.crosscollateralliquidationhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = 1209581111247235310L;
	
	//Variables
	private String coin;
	private double collateralAmountForLiquidation;
	private String collateralCoin;
	private long forceLiquidationStartTime;
	private double restCollateralAmountAfterLiquidation;
	private double restLoanAmount;
	private String status;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoin() {
		return this.coin;
	}
	
	public final double getCollateralAmountForLiquidation() {
		return this.collateralAmountForLiquidation;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final long getForceLiquidationStartTime() {
		return this.forceLiquidationStartTime;
	}
	
	public final double getRestCollateralAmountAfterLiquidation() {
		return this.restCollateralAmountAfterLiquidation;
	}
	
	public final double getRestLoanAmount() {
		return this.restLoanAmount;
	}
	
	public final String getStatus() {
		return this.status;
	}
}