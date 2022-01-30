package fr.rowlaxx.binanceapi.core.nft;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class NFTTransactionRecord extends JsavonObject {
	private static final long serialVersionUID = -2252393257501747185L;

	private String orderNo;
	private long tradeTime;
	private double tradeAmount;
	private String tradeCurrency;
	private List<NFT> tokens;
	
	public NFTTransactionRecord(JSONObject json) {
		super(json);
	}
	
	public final String getOrderNo() {
		return orderNo;
	}
	
	public final List<NFT> getTokens() {
		return tokens;
	}
	
	public final double getTradeAmount() {
		return tradeAmount;
	}
	
	public final String getTradeCurrency() {
		return tradeCurrency;
	}
	
	public final long getTradeTime() {
		return tradeTime;
	}	
}
