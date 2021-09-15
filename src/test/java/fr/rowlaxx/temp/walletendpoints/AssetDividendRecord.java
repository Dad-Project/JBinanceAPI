package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.assetdividendrecord.Rows;

import java.util.List;

import org.json.JSONObject;

public class AssetDividendRecord extends JSavONObject {
	private static final long serialVersionUID = 4394987420429024652L;
	
	//Variables
	private List<Rows> rows;
	private int total;
	
	//Constructeurs
	public AssetDividendRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Rows> getRows() {
		return this.rows;
	}
	
	public final int getTotal() {
		return this.total;
	}
}