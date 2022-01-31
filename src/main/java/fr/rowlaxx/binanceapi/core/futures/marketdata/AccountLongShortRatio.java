package fr.rowlaxx.binanceapi.core.futures.marketdata;

import org.json.JSONObject;

public abstract class AccountLongShortRatio extends LongShortRatio {
	private static final long serialVersionUID = 6255899287145109805L;
	
	private double longAccount;
	private double shortAccount;

	public AccountLongShortRatio(JSONObject json) {
		super(json);
	}

	public final double getLongAccount() {
		return longAccount;
	}
	
	public final double getShortAccount() {
		return shortAccount;
	}
}