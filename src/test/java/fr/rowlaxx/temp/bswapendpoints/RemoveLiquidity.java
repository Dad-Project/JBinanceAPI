package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class RemoveLiquidity extends JSavONObject {
	private static final long serialVersionUID = -1049476844287507612L;
	
	//Variables
	private int operationId;
	
	//Constructeurs
	public RemoveLiquidity(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getOperationId() {
		return this.operationId;
	}
}