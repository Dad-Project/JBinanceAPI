package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getfuturespositionriskofsubaccountv2.FuturePositionRiskVos;

import java.util.List;

import org.json.JSONObject;

public class GetFuturesPositionRiskofSubaccountV2 extends JSavONObject {
	private static final long serialVersionUID = 4389750765411237856L;
	
	//Variables
	private List<FuturePositionRiskVos> futurePositionRiskVos;
	
	//Constructeurs
	public GetFuturesPositionRiskofSubaccountV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<FuturePositionRiskVos> getFuturePositionRiskVos() {
		return this.futurePositionRiskVos;
	}
}