package fr.rowlaxx.binanceapi.core.general.options;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class OptionAsset extends JsavonObject {
	private static final long serialVersionUID = -3751210553171232844L;

	//Variables
	private String name;
	private int id;
	
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
