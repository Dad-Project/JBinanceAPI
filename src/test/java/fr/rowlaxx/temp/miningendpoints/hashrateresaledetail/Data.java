package fr.rowlaxx.temp.miningendpoints.hashrateresaledetail;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.hashrateresaledetail.data.ProfitTransferDetails;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 8451119276590588806L;
	
	//Variables
	private int pageSize;
	private List<ProfitTransferDetails> profitTransferDetails;
	private int totalNum;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getPageSize() {
		return this.pageSize;
	}
	
	public final List<ProfitTransferDetails> getProfitTransferDetails() {
		return this.profitTransferDetails;
	}
	
	public final int getTotalNum() {
		return this.totalNum;
	}
}