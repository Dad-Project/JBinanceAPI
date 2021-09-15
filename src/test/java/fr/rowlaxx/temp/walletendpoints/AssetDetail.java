package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.assetdetail.CTR;
import fr.rowlaxx.temp.walletendpoints.assetdetail.SKY;

import org.json.JSONObject;

public class AssetDetail extends JSavONObject {
	private static final long serialVersionUID = -6117121301033417406L;
	
	//Variables
	private CTR CTR;
	private SKY SKY;
	
	//Constructeurs
	public AssetDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final CTR getCTR() {
		return this.CTR;
	}
	
	public final SKY getSKY() {
		return this.SKY;
	}
}