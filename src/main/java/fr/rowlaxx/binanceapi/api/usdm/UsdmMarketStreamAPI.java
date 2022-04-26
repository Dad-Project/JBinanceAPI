package fr.rowlaxx.binanceapi.api.usdm;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.websocket.StreamAPI;
import fr.rowlaxx.binanceapi.core.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.futures.marketstream.MarkPrice;
import fr.rowlaxx.jsavon.Jsavon;
import fr.rowlaxx.utils.IterableArray;

public class UsdmMarketStreamAPI extends StreamAPI implements Api.Usdm {

	//Interfaces
	public static interface OnAggTrade{
		public void onAggTrade(String symbol, CompressedTrade trade);
	}
	
	public static interface OnMarkPrice{
		public void onMarkPrice(String symbol, MarkPrice markPrice);
	}
	
	public static interface OnCandle{
		public void onCandle(String symbol, Intervals interval, BasicCandlestick candle);
	}
	
	//Variables
	private final List<OnAggTrade> onAggTrades = new LinkedList<>();
	private final List<OnMarkPrice> onMarkPrices = new LinkedList<>();
	private final List<OnCandle> onCandles = new LinkedList<>();
	
	//Constructeurs
	public UsdmMarketStreamAPI() {
		super("wss://fstream.binance.com");
	}
	
	//Methodes réecrites
	@Override
	public void clearEvents() {
		this.onAggTrades.clear();
		this.onMarkPrices.clear();
		this.onCandles.clear();
	}

	@Override
	protected void onJson(JSONObject json) {
		final String eventType = json.optString("e", null);
		final String symbol = json.optString("s", null);
		
		if ("aggTrade".equals(eventType)) {
			final CompressedTrade trade = Jsavon.converter.convert(json, CompressedTrade.class);
			for (OnAggTrade event : onAggTrades)
				event.onAggTrade(symbol, trade);
		}
		else if ("markPriceUpdate".equals(eventType)) {
			final MarkPrice markPrice = Jsavon.converter.convert(json, MarkPrice.class);
			for (OnMarkPrice event : onMarkPrices)
				event.onMarkPrice(symbol, markPrice);
		}
		else if ("kline".equals(eventType)) {
			final BasicCandlestick candle = new BasicCandlestick(json.getJSONArray("k"));
			final Intervals interval = Jsavon.converter.convert(json.getJSONObject("k").get("i"), Intervals.class);
			for (OnCandle event : onCandles)
				event.onCandle(symbol, interval, candle);
		}
	}
 
	//Methodes
	public void subscribeAggTrade(Iterable<String> symbols) {
		pool.subscribe(append(symbols, "@aggTrade", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeAggTrade(Iterable<String> symbols) {
		pool.unsubscribe(append(symbols, "@aggTrade", AppendMode.LOWER_CASE));
	}
	
	public void subscribeAggTrade(String... symbols) {
		subscribeAggTrade(new IterableArray<>(symbols));
	}
	
	public void unsubscribeAggTrade(String... symbols) {
		subscribeAggTrade(new IterableArray<>(symbols));
	}

	public void addOnAggTradeEvent(OnAggTrade onAggTrade) {
		if (onAggTrade == null)
			return;
		this.onAggTrades.add(onAggTrade);
	}
	
	public void subscribeMarkPrice(Iterable<String> symbols, long updateTime) {
		if (updateTime != 1000 && updateTime != 3000)
			throw new IllegalArgumentException("updateTime must be 1000ms or 3000ms.");
		if (updateTime == 1000)
			pool.subscribe(append(symbols, "@markPrice@1s", AppendMode.LOWER_CASE));
		else
			pool.subscribe(append(symbols, "@markPrice", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeMarkPrice(Iterable<String> symbols, long updateTime) {
		if (updateTime != 1000 && updateTime != 3000)
			throw new IllegalArgumentException("updateTime must be 1000ms or 3000ms.");
		if (updateTime == 1000)
			pool.unsubscribe(append(symbols, "@markPrice@1s", AppendMode.LOWER_CASE));
		else
			pool.unsubscribe(append(symbols, "@markPrice", AppendMode.LOWER_CASE));
	}
	
	public void subscribeMarkPrice(long updateTime, String... symbols) {
		subscribeMarkPrice(new IterableArray<>(symbols), updateTime);
	}
	
	public void unsubscribeMarkPrice(long updateTime, String... symbols) {
		unsubscribeMarkPrice(new IterableArray<>(symbols), updateTime);
	}
	
	public void addOnMarkPriceEvent(OnMarkPrice onMarkPrice) {
		if (onMarkPrice == null)
			return;
		this.onMarkPrices.add(onMarkPrice);
	}
	
	public void subscribeMarkPrices(long updateTime) {
		if (updateTime != 1000 && updateTime != 3000)
			throw new IllegalArgumentException("updateTime must be 1000ms or 3000ms.");
		if (updateTime == 1000)
			pool.subscribe("!markPrice@arr@1s");
		else
			pool.subscribe("!markPrice@arr");
	}
	
	public void unsubscribeMarkPrices(long updateTime) {
		if (updateTime != 1000 && updateTime != 3000)
			throw new IllegalArgumentException("updateTime must be 1000ms or 3000ms.");
		if (updateTime == 1000)
			pool.unsubscribe("!markPrice@arr@1s");
		else
			pool.unsubscribe("!markPrice@arr");
	}
	
	public void subscribeCandlestick(Iterable<String> symbols, Intervals interval) {
		pool.subscribe(append(symbols, "@kline_" + interval, AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeCandlestick(Iterable<String> symbols, Intervals interval) {
		pool.unsubscribe(append(symbols, "@kline_" + interval, AppendMode.LOWER_CASE));
	}
	
	public void subscribeCandlestick(Intervals interval, String... symbols) {
		subscribeCandlestick(new IterableArray<>(symbols), interval);
	}
	
	public void unsubscribeCandlestick(Intervals interval, String... symbols) {
		unsubscribeCandlestick(new IterableArray<>(symbols), interval);
	}
	
	public void addOnCandleEvent(OnCandle onCandle) {
		if (onCandle == null)
			return;
		this.onCandles.add(onCandle);
	}
}
