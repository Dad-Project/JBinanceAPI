package fr.rowlaxx.binanceapi.core.coinm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountBalance;

public class CoinmAccountBalance extends FutureAccountBalance {
	private static final long serialVersionUID = -8650958641930178883L;

	private double withdrawAvailable;
	
	public CoinmAccountBalance(JSONObject json) {
		super(json);
	}
	
	public final double getWithdrawAvailable() {
		return withdrawAvailable;
	}

}
