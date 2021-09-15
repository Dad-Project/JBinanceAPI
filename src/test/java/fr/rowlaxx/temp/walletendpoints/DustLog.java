package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dustlog.UserAssetDribblets;

import java.util.List;

import org.json.JSONObject;

public class DustLog extends JSavONObject {
	private static final long serialVersionUID = 7695273102953219197L;
	
	//Variables
	private int total;
	private List<UserAssetDribblets> userAssetDribblets;
	
	//Constructeurs
	public DustLog(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTotal() {
		return this.total;
	}
	
	public final List<UserAssetDribblets> getUserAssetDribblets() {
		return this.userAssetDribblets;
	}
}