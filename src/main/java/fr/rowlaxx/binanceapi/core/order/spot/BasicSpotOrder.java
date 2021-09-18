package fr.rowlaxx.binanceapi.core.order.spot;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.BasicOrder;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class BasicSpotOrder extends BasicOrder<SpotOrderTypes> {
	private static final long serialVersionUID = 7083133669058208925L;

	//Variables
	@JOValue(mandatory = false)
	private Double cummulativeQuoteQty;
	@JOValue(mandatory = false)
	private List<Fill> fills;
	
	//Constructeurs
	public BasicSpotOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Double getCummulativeQuoteQty() {
		return cummulativeQuoteQty;
	}
	
	public final List<Fill> getFills() {
		return fills;
	}
}