package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class Basis extends JsavonObject {
	private static final long serialVersionUID = 2542517250718174L;
	
	//Variables
	private double basis;
	private double basisRate;
	private ContractTypes contractType;
	private double futuresPrice;
	private double indexPrice;
	private String pair;
	private long timestamp;
	
	//Constructeurs
	public Basis(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBasis() {
		return this.basis;
	}
	
	public final double getBasisRate() {
		return this.basisRate;
	}
	
	public final ContractTypes getContractType() {
		return this.contractType;
	}
	
	public final double getFuturesPrice() {
		return this.futuresPrice;
	}
	
	public final double getIndexPrice() {
		return this.indexPrice;
	}
	
	public final String getPair() {
		return this.pair;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
}