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
import fr.rowlaxx.utils.IterableArray;

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
	public void subscribeInfo(Iterable<String> symbols) {
		pool.subscribe(append(symbols, "@tokenNav", AppendMode.UPPER_CASE));
	}
	
	public void unsubscribeInfo(Iterable<String> symbols) {
		pool.unsubscribe(append(symbols, "@tokenNav", AppendMode.UPPER_CASE));
	}
	
	public void subscribeInfo(String... symbols) {
		subscribeInfo(new IterableArray<>(symbols));
	}
	
	public void unsubscribeInfo(String... symbols) {
		unsubscribeInfo(new IterableArray<>(symbols));
	}
	
	public void subscribeCandlestick(Iterable<String> symbols, Intervals interval) {
		pool.subscribe(append(symbols, "@nav_kline_" + interval, AppendMode.UPPER_CASE));
	}
	
	public void subscribeCandlestick(Intervals interval, String... symbols) {
		subscribeCandlestick(new IterableArray<>(symbols), interval);
	}
	
	public void unsubscribeCandlestick(Iterable<String> symbols, Intervals interval) {
		pool.unsubscribe(append(symbols, "@nav_kline_" + interval, AppendMode.UPPER_CASE));
	}
	
	public void unsubscribeCandlestick(Intervals interval, String... symbols) {
		unsubscribeCandlestick(new IterableArray<>(symbols), interval);
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
