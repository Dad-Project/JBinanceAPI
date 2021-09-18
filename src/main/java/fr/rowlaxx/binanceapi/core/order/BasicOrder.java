package fr.rowlaxx.binanceapi.core.order;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class BasicOrder<T extends OrderTypes> extends Order<T, BasicOrderStatus> {
	private static final long serialVersionUID = -1507195026482848443L;

	//Variables
	@JOValue(mandatory = false)
	private double origQty;
	
	//Constructeurs
	public BasicOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getOrigQty() {
		return origQty;
	}
}