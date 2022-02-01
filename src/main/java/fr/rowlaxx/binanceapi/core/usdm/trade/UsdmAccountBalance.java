package fr.rowlaxx.binanceapi.core.usdm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountBalance;

public class UsdmAccountBalance extends FutureAccountBalance {
	private static final long serialVersionUID = 2533175550617247574L;

	private double maxWithdrawAmount;
	private boolean marginAvailable;
	
	public UsdmAccountBalance(JSONObject json) {
		super(json);
	}
	
	public final double getMaxWithdrawAmount() {
		return maxWithdrawAmount;
	}
	
	public final boolean isMarginAvailable() {
		return marginAvailable;
	}
}
