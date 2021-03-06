package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SwapRecord extends JsavonObject {
	private static final long serialVersionUID = -338931940600086376L;
	
	//Variables
	private String baseAsset;
	private int baseQty;
	private int fee;
	private double price;
	private String quoteAsset;
	private int quoteQty;
	private LiquidityOperationStatus status;
	private int swapId;
	private long swapTime;
	
	//Constructeurs
	public SwapRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBaseAsset() {
		return this.baseAsset;
	}
	
	public final int getBaseQty() {
		return this.baseQty;
	}
	
	public final int getFee() {
		return this.fee;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final int getQuoteQty() {
		return this.quoteQty;
	}
	
	public final LiquidityOperationStatus getStatus() {
		return this.status;
	}
	
	public final int getSwapId() {
		return this.swapId;
	}
	
	public final long getSwapTime() {
		return this.swapTime;
	}
}