package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AddLiquidity extends JSavONObject {
	private static final long serialVersionUID = 6734005486290666513L;
	
	//Variables
	private int operationId;
	
	//Constructeurs
	public AddLiquidity(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getOperationId() {
		return this.operationId;
	}
}