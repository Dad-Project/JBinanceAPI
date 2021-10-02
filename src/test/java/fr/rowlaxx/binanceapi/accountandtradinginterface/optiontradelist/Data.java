package fr.rowlaxx.temp.accountandtradinginterface.optiontradelist;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -7981397332405286757L;
	
	//Variables
	private long createDate;
	private int fee;
	private long id;
	private String liquidity;
	private int price;
	private int quantity;
	private String quoteAsset;
	private int realizedProfit;
	private String side;
	private String symbol;
	private String type;
	private String volatility;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCreateDate() {
		return this.createDate;
	}
	
	public final int getFee() {
		return this.fee;
	}
	
	public final long getId() {
		return this.id;
	}
	
	public final String getLiquidity() {
		return this.liquidity;
	}
	
	public final int getPrice() {
		return this.price;
	}
	
	public final int getQuantity() {
		return this.quantity;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final int getRealizedProfit() {
		return this.realizedProfit;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final String getVolatility() {
		return this.volatility;
	}
}