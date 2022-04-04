package fr.rowlaxx.binanceapi.api.spot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.websocket.StreamAPI;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.spot.stream.SpotStreamTrade;
import fr.rowlaxx.jsavon.Jsavon;

public class SpotMarketDataStreamAPI extends StreamAPI implements Api.Spot {

	//Events
	public static interface OnTrade{
		public void onTrade(String symbol, SpotStreamTrade trade);
	}
	
	public static interface OnAggTrade{
		public void onAggTrade(String symbol, CompressedTrade trade);
	}
	
	//Variables
	private List<OnTrade> onTrades = new ArrayList<>();
	private List<OnAggTrade> onAggTrades = new ArrayList<>();
	
	//Constructeurs
	public SpotMarketDataStreamAPI() {
		super("wss://stream.binance.com:9443");
	}
	
	//Methodes reecrites
	@Override
	protected void onJson(JSONObject json) {
		final String eventType = json.getString("e");
		final String symbol = json.getString("s");
		
		if (eventType.equals("trade")) {
			final SpotStreamTrade trade = Jsavon.converter.convert(json, SpotStreamTrade.class);
			for (OnTrade event : onTrades)
				event.onTrade(symbol, trade);
		}
		else if (eventType.equals("aggTrade")) {
			final CompressedTrade trade = Jsavon.converter.convert(json, CompressedTrade.class);
			for (OnAggTrade event : onAggTrades)
				event.onAggTrade(symbol, trade);
		}
	}
	
	//Methodes
	public void subscribeTrade(List<String> symbols) {
		pool.subscribe(append(symbols, "@trade"));
	}
	
	public void subscribeTrade(String symbol) {
		pool.subscribe(symbol + "@trade");
	}
	
	public void unsubscribeTrade(List<String> symbols) {
		pool.unsubscribe(append(symbols, "@trade"));
	}
	
	public void unsubscribeTrade(String symbol) {
		pool.unsubscribe(symbol + "@trade");
	}
	
	public void subscribeAggTrade(List<String> symbols) {
		pool.subscribe(append(symbols, "@aggTrade"));
	}
	
	public void unsubscribeAggTrade(List<String> symbols) {
		pool.unsubscribe(append(symbols, "@aggTrade"));
	}
	
	public void subscribeAggTrade(String symbol) {
		pool.subscribe(symbol + "@aggTrade");
	}
	
	public void unsubscribeAggTrade(String symbol) {
		pool.unsubscribe(symbol + "@aggTrade");
	}
	
	public void addOnTradeEvent(OnTrade onTrade) {
		this.onTrades.add(onTrade);
	}
	
	public void addOnAggTradeEvent(OnAggTrade onAggTrade) {
		this.onAggTrades.add(onAggTrade);
	}
	
	@Override
	public void clearEvents() {
		this.onTrades.clear();
	}

}
