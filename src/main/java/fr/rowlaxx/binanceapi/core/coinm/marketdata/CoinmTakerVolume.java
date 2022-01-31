package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class CoinmTakerVolume extends JsavonObject {
	private static final long serialVersionUID = 8649026809372746158L;
	
	//Variables
	private ContractTypes contractType;
	private String pair;
	private double takerBuyVol;
	private double takerBuyVolValue;
	private double takerSellVol;
	private double takerSellVolValue;
	private long timestamp;
	
	//Constructeurs
	public CoinmTakerVolume(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final ContractTypes getContractType() {
		return this.contractType;
	}
	
	public final String getPair() {
		return this.pair;
	}
	
	public final double getTakerBuyVol() {
		return this.takerBuyVol;
	}
	
	public final double getTakerBuyVolValue() {
		return this.takerBuyVolValue;
	}
	
	public final double getTakerSellVol() {
		return this.takerSellVol;
	}
	
	public final double getTakerSellVolValue() {
		return this.takerSellVolValue;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
}