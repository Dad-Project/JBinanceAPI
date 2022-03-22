package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.JsavonObject;

public class BNBConvertableAsset extends JsavonObject {
	private static final long serialVersionUID = 7812963916227653894L;

	private String asset;
	private String assetFullName;
	private double amountFree;
	private double toBTC;
	private double toBNB;
	private double toBNBOffExchange;
	private double exchange;
	
	public final double getAmountFree() {
		return amountFree;
	}
	
	public final String getAsset() {
		return asset;
	}
	
	public final String getAssetFullName() {
		return assetFullName;
	}
	
	public final double getExchange() {
		return exchange;
	}
	
	public final double getToBNB() {
		return toBNB;
	}
	
	public final double getToBNBOffExchange() {
		return toBNBOffExchange;
	}
	
	public final double getToBTC() {
		return toBTC;
	}
}
