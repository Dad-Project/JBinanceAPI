package fr.rowlaxx.binanceapi.core.futuresalgo;

import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.futures.trade.PositionSides;
import fr.rowlaxx.jsavon.JsavonObject;

public class VPOrder extends JsavonObject {
	private static final long serialVersionUID = -522552714683309986L;

	//Variables
	private long algoId;
	private String symbol;
	private OrderSides side;
	private PositionSides positionSide;
	private double totalQty;
	private double executedQty;
	private double executedAmt;
	private double avgPrice;
	private String clientAlgoId;
	private long bookTime;
	private long endTime;
	private AlgoStatus algoStatus;
	private AlgoTypes algoType;
	private Urgency urgency;
	
	//Getters
	public long getAlgoId() {
		return algoId;
	}
	
	public AlgoStatus getAlgoStatus() {
		return algoStatus;
	}
	
	public AlgoTypes getAlgoType() {
		return algoType;
	}
	
	public double getAvgPrice() {
		return avgPrice;
	}
	
	public long getBookTime() {
		return bookTime;
	}
	
	public String getClientAlgoId() {
		return clientAlgoId;
	}
	
	public long getEndTime() {
		return endTime;
	}
	
	public double getExecutedAmt() {
		return executedAmt;
	}
	
	public double getExecutedQty() {
		return executedQty;
	}
	
	public PositionSides getPositionSide() {
		return positionSide;
	}
	
	public OrderSides getSide() {
		return side;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public double getTotalQty() {
		return totalQty;
	}
	
	public Urgency getUrgency() {
		return urgency;
	}
}
