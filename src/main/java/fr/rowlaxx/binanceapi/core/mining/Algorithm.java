package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Algorithm extends JsavonObject {
	private static final long serialVersionUID = 6469494209005987883L;
	
	//Variables
	private int algoId;
	private String algoName;
	private int poolIndex;
	private String unit;
	
	//Constructeurs
	public Algorithm(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAlgoId() {
		return this.algoId;
	}
	
	public final String getAlgoName() {
		return this.algoName;
	}
	
	public final int getPoolIndex() {
		return this.poolIndex;
	}
	
	public final String getUnit() {
		return this.unit;
	}
}