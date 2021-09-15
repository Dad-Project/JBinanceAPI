package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo1.Assets;

import java.util.List;

import org.json.JSONObject;

public class QueryIsolatedMarginAccountInfo1 extends JSavONObject {
	private static final long serialVersionUID = 5314280114177961462L;
	
	//Variables
	private List<Assets> assets;
	
	//Constructeurs
	public QueryIsolatedMarginAccountInfo1(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Assets> getAssets() {
		return this.assets;
	}
}