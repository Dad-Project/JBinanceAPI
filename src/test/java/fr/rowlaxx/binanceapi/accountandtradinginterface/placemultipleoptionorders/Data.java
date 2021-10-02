package fr.rowlaxx.temp.accountandtradinginterface.placemultipleoptionorders;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.placemultipleoptionorders.data.LastTrade;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 841370355774088344L;
	
	//Variables
	private int avgPrice;
	private String clientOrderId;
	private long createDate;
	private int executedQty;
	private int fee;
	private long id;
	private LastTrade lastTrade;
	private int price;
	private int quantity;
	private boolean reduceOnly;
	private String side;
	private String source;
	private String status;
	private String symbol;
	private String timeInForce;
	private String type;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAvgPrice() {
		return this.avgPrice;
	}
	
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final long getCreateDate() {
		return this.createDate;
	}
	
	public final int getExecutedQty() {
		return this.executedQty;
	}
	
	public final int getFee() {
		return this.fee;
	}
	
	public final long getId() {
		return this.id;
	}
	
	public final LastTrade getLastTrade() {
		return this.lastTrade;
	}
	
	public final int getPrice() {
		return this.price;
	}
	
	public final int getQuantity() {
		return this.quantity;
	}
	
	public final boolean isReduceOnly() {
		return this.reduceOnly;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final String getSource() {
		return this.source;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final String getTimeInForce() {
		return this.timeInForce;
	}
	
	public final String getType() {
		return this.type;
	}
}