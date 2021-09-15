package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.acquiringalgorithm.Data;

import java.util.List;

import org.json.JSONObject;

public class AcquiringAlgorithm extends JSavONObject {
	private static final long serialVersionUID = 5645860759764499085L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String msg;
	
	//Constructeurs
	public AcquiringAlgorithm(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<Data> getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}