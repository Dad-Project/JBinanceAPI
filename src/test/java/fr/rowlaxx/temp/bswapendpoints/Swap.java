package fr.rowlaxx.temp.bswapendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Swap extends JSavONObject {
	private static final long serialVersionUID = -3975358059451963108L;
	
	//Variables
	private int swapId;
	
	//Constructeurs
	public Swap(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getSwapId() {
		return this.swapId;
	}
}