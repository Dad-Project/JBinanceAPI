package fr.rowlaxx.binanceapi.core.order.spot;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.OcoOrder;

public class SpotOCOOrder extends OcoOrder<SpotOrder> {
	private static final long serialVersionUID = -7948252563213144921L;

	//Constructeurs
	public SpotOCOOrder(JSONObject json) {
		super(json);
	}

}
