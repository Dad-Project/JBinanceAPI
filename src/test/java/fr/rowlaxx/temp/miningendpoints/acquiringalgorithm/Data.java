package fr.rowlaxx.temp.miningendpoints.acquiringalgorithm;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 6469494209005987883L;
	
	//Variables
	private int algoId;
	private String algoName;
	private int poolIndex;
	private String unit;
	
	//Constructeurs
	public Data(JSONObject json) {
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