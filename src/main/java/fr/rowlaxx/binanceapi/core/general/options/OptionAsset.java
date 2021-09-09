package fr.rowlaxx.binanceapi.core.general.options;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class OptionAsset extends JSavONObject {
	private static final long serialVersionUID = -3751210553171232844L;

	//Variables
	@JOValue private String name;
	@JOValue private int id;
	
	//Constructeurs
	public OptionAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
