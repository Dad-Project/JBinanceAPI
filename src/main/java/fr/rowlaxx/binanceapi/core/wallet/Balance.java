package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Balance extends JSavONObject {
	private static final long serialVersionUID = -8794330584396782394L;

	//Variables
	@JOValue private String asset;
	@JOValue private double free;
	@JOValue private double locked;
	
	//Constructeurs
	public Balance(JSONObject json) {
		super(json);
	}
	
	//Getters
	public String getAsset() {
		return asset;
	}
	
	public double getFree() {
		return free;
	}
	
	public double getLocked() {
		return locked;
	}
}
