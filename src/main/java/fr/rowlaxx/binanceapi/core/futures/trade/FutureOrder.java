package fr.rowlaxx.binanceapi.core.futures.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.BasicOrder;
import fr.rowlaxx.jsavon.annotations.JOValue;

public abstract class FutureOrder extends BasicOrder<FutureOrderTypes> {
	private static final long serialVersionUID = -4526521473369286889L;

	//Variables
	@JOValue(mandatory = false)
	private Double cumQty;
	private double avgPrice;
	private boolean reduceOnly;
	private PositionSides positionSide;
	private boolean closePosition;
	private FutureOrderTypes origType;
	@JOValue(mandatory = false)
	private Double activationPrice;
	private WorkingType workingType;
	@JOValue(mandatory = false)
	private Double priceRate;
	@JOValue(mandatory = false)
	private Boolean priceProtect;
	
	//Constructeurs
	public FutureOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean closePosition() {
		return closePosition;
	}
	
	public final Boolean priceProtect() {
		return priceProtect;
	}
	
	public final boolean isReduceOnly() {
		return reduceOnly;
	}
	
	public final Double getActivationPrice() {
		return activationPrice;
	}
	
	public final double getAvgPrice() {
		return avgPrice;
	}
	
	public final Double getCumQty() {
		return cumQty;
	}

	public final FutureOrderTypes getOrigType() {
		return origType;
	}
	
	public final PositionSides getPositionSide() {
		return positionSide;
	}
	
	public final Double getPriceRate() {
		return priceRate;
	}
	
	public final WorkingType getWorkingType() {
		return workingType;
	}
}