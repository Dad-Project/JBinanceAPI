package fr.rowlaxx.binanceapi.core.wallet.future;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Asset extends JSavONObject {
	private static final long serialVersionUID = 5648115132270203784L;

	@JOValue private String asset;
	@JOValue private double marginBalance, walletBalance;
	
	public Asset(JSONObject json) {
		super(json);
	}
	
	public String getAsset() {
		return asset;
	}
	
	public double getMarginBalance() {
		return marginBalance;
	}
	
	public double getWalletBalance() {
		return walletBalance;
	}
}
