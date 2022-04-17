package fr.rowlaxx.binanceapi.api.spot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.websocket.StreamAPI;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.blvt.BlvtCandlestick;
import fr.rowlaxx.binanceapi.core.blvt.BlvtInfoStream;
import fr.rowlaxx.jsavon.Jsavon;

public class BLVTStreamAPI extends StreamAPI implements Api.WebSocket, Api.Spot{

	//Events
	public static interface OnCandle{
		public void onCandle(String symbol, BlvtCandlestick candle);
	}
	
	public static interface OnInfo{
		public void onInfo(String symbol, BlvtInfoStream info);
	}
	
	//Variables
	private List<OnCandle> onCandles = new ArrayList<OnCandle>();
	private List<OnInfo> onInfos = new ArrayList<OnInfo>();
	
	//Constructeurs
	public BLVTStreamAPI() {
		super("wss://nbstream.binance.com/lvt-p");
	}

	//Methodes
	public void subscribeInfo(List<String> symbols) {
		pool.subscribe(append(symbols, "@tokenNav", AppendMode.UPPER_CASE));
	}
	
	public void unsubscribeInfo(List<String> symbols) {
		pool.unsubscribe(append(symbols, "@tokenNav", AppendMode.UPPER_CASE));
	}
	
	public void subscribeInfo(String symbol) {
		pool.subscribe(symbol.toUpperCase() + "@tokenNav");
	}
	
	public void unsubscribeInfo(String symbol) {
		pool.unsubscribe(symbol.toUpperCase() + "@tokenNav");
	}
	
	public void subscribeCandlestick(List<String> symbols, Intervals interval) {
		pool.subscribe(append(symbols, "@nav_kline_" + interval, AppendMode.UPPER_CASE));
	}
	
	public void subscribeCandlestick(String symbol, Intervals interval) {
		pool.subscribe(symbol.toUpperCase() + "@nav_kline_" + interval);
	}
	
	public void unsubscribeCandlestick(List<String> symbols, Intervals interval) {
		pool.unsubscribe(append(symbols, "@nav_kline_" + interval, AppendMode.UPPER_CASE));
	}
	
	public void unsubscribeCandlestick(String symbol, Intervals interval) {
		pool.unsubscribe(symbol.toUpperCase() + "@nav_kline_" + interval);
	}
	
	
	@Override
	public void clearEvents() {
		this.onCandles.clear();
		this.onInfos.clear();
	}

	@Override
	protected void onJson(JSONObject json) {
		final String eventType = json.optString("e", null);
		final String symbol = json.optString("s", null);
		
		if ("kline".equals(eventType)) {
			final BlvtCandlestick candle = new BlvtCandlestick(json.getJSONObject("k"));
			for(OnCandle event : onCandles)
				event.onCandle(symbol, candle);
		}
		else if ("nav".equals(eventType)) {
			final BlvtInfoStream info = Jsavon.converter.convert(json, BlvtInfoStream.class);
			for(OnInfo event : onInfos)
				event.onInfo(symbol, info);
		}
	}

	public void addOnInfoEvent(OnInfo event) {
		this.onInfos.add(event);
	}
	
	public void addOnCandlestickEvent(OnCandle event) {
		this.onCandles.add(event);
	}
}
