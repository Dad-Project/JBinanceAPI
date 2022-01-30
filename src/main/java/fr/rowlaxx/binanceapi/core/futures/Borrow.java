package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class Borrow extends JsavonObject {
	private static final long serialVersionUID = 2063292274424751843L;
	
	//Variables
	private double amount;
	private long borrowId;
	private String coin;
	private double collateralAmount;
	private String collateralCoin;
	@JOValue(key = {"time", "confirmedTime"})
	private long time;
	
	//Constructeurs
	public Borrow(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final long getBorrowId() {
		return this.borrowId;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final double getCollateralAmount() {
		return this.collateralAmount;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final long getTime() {
		return this.time;
	}
}