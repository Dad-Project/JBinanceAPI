package fr.rowlaxx.binanceapi.core.order.future;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.BasicOrder;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class FutureOrder extends BasicOrder<FutureOrderTypes> {
	private static final long serialVersionUID = -4526521473369286889L;

	//Variables
	@JOValue(mandatory = false)
	private Double cumQty;
	private double avgPrice;
	private boolean reduceOnly;
	private PositionSides positionSide;
	private double stopPrice;
	private boolean closePosition;
	private FutureOrderTypes origType;
	@JOValue(mandatory = false)
	private Double activationPrice;
	private WorkingType workingType;
	@JOValue(mandatory = false)
	private Double priceRate;
	@JOValue(mandatory = false)
	private Boolean priceProtect;
	@JOValue(mandatory = false)
	private Long time;
	
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
	
	public final double getStopPrice() {
		return stopPrice;
	}
	
	public final long getTime() {
		return time;
	}
	
	public final WorkingType getWorkingType() {
		return workingType;
	}
}