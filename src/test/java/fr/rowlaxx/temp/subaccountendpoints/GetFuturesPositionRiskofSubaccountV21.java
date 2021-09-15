package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getfuturespositionriskofsubaccountv21.DeliveryPositionRiskVos;

import java.util.List;

import org.json.JSONObject;

public class GetFuturesPositionRiskofSubaccountV21 extends JSavONObject {
	private static final long serialVersionUID = 249052076749717217L;
	
	//Variables
	private List<DeliveryPositionRiskVos> deliveryPositionRiskVos;
	
	//Constructeurs
	public GetFuturesPositionRiskofSubaccountV21(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<DeliveryPositionRiskVos> getDeliveryPositionRiskVos() {
		return this.deliveryPositionRiskVos;
	}
}