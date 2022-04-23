package fr.rowlaxx.binanceapi.api.spot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.websocket.StreamAPI;
import fr.rowlaxx.binanceapi.core.BookTicker;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.MiniTicker;
import fr.rowlaxx.binanceapi.core.OrderBook;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTickerStatistics;
import fr.rowlaxx.binanceapi.core.spot.marketstream.SpotStreamCandlestick;
import fr.rowlaxx.binanceapi.core.spot.marketstream.SpotStreamTrade;
import fr.rowlaxx.jsavon.Jsavon;

public class SpotMarketStreamAPI extends StreamAPI implements Api.Spot {

	//Events
	public static interface OnTrade{
		public void onTrade(String symbol, SpotStreamTrade trade);
	}
	
	public static interface OnAggTrade{
		public void onAggTrade(String symbol, CompressedTrade trade);
	}
	
	public static interface OnCandle{
		public void onCandle(String symbol, SpotStreamCandlestick candle);
	}
	
	public static interface OnTicker{
		public void onTicker(String symbol, SpotTickerStatistics statistics);
	}
	
	public static interface OnMiniTicker{
		public void onMiniTicker(String symbol, MiniTicker ticker);
	}
	
	public static interface OnBookTicker{
		public void onBookTicker(String symbol, BookTicker ticker);
	}
	
	public static interface OnPartialDiffBook{
		public void onPartialDiffBook(OrderBook orderBook);
	}
	
	public static interface OnDiffBook{
		public void onDiffBook(String symbol, OrderBook orderBook);
	}
	
	//Variables
	private List<OnTrade> onTrades = new ArrayList<>();
	private List<OnAggTrade> onAggTrades = new ArrayList<>();
	private List<OnCandle> onCandles = new ArrayList<>();
	private List<OnTicker> onTickers = new ArrayList<>();
	private List<OnMiniTicker> onMiniTickers = new ArrayList<>();
	private List<OnBookTicker> onBookTickers = new ArrayList<>();
	private List<OnPartialDiffBook> onPartialDiffBooks = new ArrayList<>();
	private List<OnDiffBook> onDiffBooks = new ArrayList<>();
	
	//Constructeurs
	public SpotMarketStreamAPI() {
		super("wss://stream.binance.com:9443");
	}
	
	//Methodes reecrites
	@Override
	protected void onJson(JSONObject json) {
		final String eventType = json.optString("e", null);
		final String symbol = json.optString("s", null);
		
		if ("trade".equals(eventType)) {
			final SpotStreamTrade trade = Jsavon.converter.convert(json, SpotStreamTrade.class);
			for (OnTrade event : onTrades)
				event.onTrade(symbol, trade);
		}
		else if ("aggTrade".equals(eventType)) {
			final CompressedTrade trade = Jsavon.converter.convert(json, CompressedTrade.class);
			for (OnAggTrade event : onAggTrades)
				event.onAggTrade(symbol, trade);
		}		
		else if ("kline".equals(eventType)) {
			final SpotStreamCandlestick candle = Jsavon.converter.convert(json, SpotStreamCandlestick.class);
			for (OnCandle event : onCandles)
				event.onCandle(symbol, candle);
		}
		else if ("24hrTicker".equals(eventType)) {
			final SpotTickerStatistics statistics = Jsavon.converter.convert(json, SpotTickerStatistics.class);
			for (OnTicker event : onTickers)
				event.onTicker(symbol, statistics);
		}
		else if ("24hrMiniTicker".equals(eventType)) {
			final MiniTicker ticker = Jsavon.converter.convert(json, MiniTicker.class);
			for (OnMiniTicker event : onMiniTickers)
				event.onMiniTicker(symbol, ticker);
		}
		else if (eventType == null && symbol != null) {
			final BookTicker ticker = Jsavon.converter.convert(json, BookTicker.class);
			for (OnBookTicker event : onBookTickers)
				event.onBookTicker(symbol, ticker);
		}
		else if (eventType == null && symbol == null) {
			final OrderBook orderBook = Jsavon.converter.convert(json, OrderBook.class);
			for (OnPartialDiffBook event : onPartialDiffBooks)
				event.onPartialDiffBook(orderBook);
		}
		else if ("depthUpdate".equals(eventType)) {
			final OrderBook orderBook = Jsavon.converter.convert(json, OrderBook.class);
			for (OnDiffBook event : onDiffBooks)
				event.onDiffBook(symbol, orderBook);
		}		
	}
	
	//Methodes
	public void subscribeTrade(List<String> symbols) {
		subscribe(append(symbols, "@trade", AppendMode.LOWER_CASE));
	}
	
	public void subscribeTrade(String symbol) {
		subscribe(symbol.toLowerCase() + "@trade");
	}
	
	public void unsubscribeTrade(List<String> symbols) {
		unsubscribe(append(symbols, "@trade", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeTrade(String symbol) {
		unsubscribe(symbol.toLowerCase() + "@trade");
	}
	
	public void subscribeAggTrade(List<String> symbols) {
		subscribe(append(symbols, "@aggTrade", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeAggTrade(List<String> symbols) {
		unsubscribe(append(symbols, "@aggTrade", AppendMode.LOWER_CASE));
	}
	
	public void subscribeAggTrade(String symbol) {
		subscribe(symbol.toLowerCase() + "@aggTrade");
	}
	
	public void unsubscribeAggTrade(String symbol) {
		unsubscribe(symbol.toLowerCase() + "@aggTrade");
	}
	
	public void subscribeCandlestick(List<String> symbols, Intervals interval) {
		subscribe(append(symbols, "@kline_" + interval, AppendMode.LOWER_CASE));
	}
	
	public void subscribeCandlestick(String symbol, Intervals interval) {
		subscribe(symbol.toLowerCase() + "@kline_" + interval);
	}
	
	public void unsubscribeCandlestick(List<String> symbols, Intervals interval) {
		unsubscribe(append(symbols, "@kline_" + interval, AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeCandlestick(String symbol, Intervals interval) {
		unsubscribe(symbol.toLowerCase() + "@kline_" + interval);
	}
	
	public void subscribeMiniTicker(List<String> symbols) {
		subscribe(append(symbols, "@miniTicker", AppendMode.LOWER_CASE));
	}
	
	public void subscribeMiniTicker(String symbol) {
		subscribe(symbol.toLowerCase() + "@miniTicker");
	}
	
	public void unsubscribeMiniTicker(List<String> symbols) {
		unsubscribe(append(symbols, "@miniTicker", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeMiniTicker(String symbol) {
		unsubscribe(symbol.toLowerCase() + "@miniTicker");
	}
	
	public void subscribeMiniTickers() {
		subscribe("!miniTicker@arr");
	}
	
	public void unsubscribeMiniTickers() {
		unsubscribe("!miniTicker@arr");
	}
	
	public void subscribeTicker(List<String> symbols) {
		subscribe(append(symbols, "@ticker", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeTicker(List<String> symbols) {
		unsubscribe(append(symbols, "@ticker", AppendMode.LOWER_CASE));
	}
	
	public void subscribeTicker(String symbol) {
		subscribe(symbol.toLowerCase() + "@ticker");
	}
	
	public void unsubscribeTicker(String symbol) {
		unsubscribe(symbol.toLowerCase() + "@ticker");
	}
	
	public void subscribeTickers() {
		subscribe("!ticker@arr");
	}
	
	public void unsubscribeTickers() {
		unsubscribe("!ticker@arr");
	}
	
	public void subscribeBookTicker(List<String> symbol) {
		subscribe(append(symbol, "@bookTicker", AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeBookTicker(List<String> symbol) {
		unsubscribe(append(symbol, "@bookTicker", AppendMode.LOWER_CASE));
	}
	
	public void subscribeBookTicker(String symbol) {
		subscribe(symbol.toLowerCase() + "@bookTicker");
	}
	
	public void unsubscribeBookTicker(String symbol) {
		unsubscribe(symbol.toLowerCase() + "@bookTicker");
	}
	
	public void subscribeBookTickers() {
		subscribe("!bookTicker");
	}
	
	public void unsubscribeBookTickers() {
		unsubscribe("!bookTicker");
	}
	
	public void subscribePartialDiffBookDepth(List<String> symbols, int level, long updatePeriod) {
		if (level != 5 && level != 10 && level != 20)
			throw new IllegalArgumentException("level must be either 5, 10 or 20.");
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		subscribe(append(symbols, "@depth" + level + (updatePeriod == 100 ? "@100ms" : ""), AppendMode.LOWER_CASE));
	}
	
	public void unsubscribePartialDiffBookDepth(List<String> symbols, int level, long updatePeriod) {
		if (level != 5 && level != 10 && level != 20)
			throw new IllegalArgumentException("level must be either 5, 10 or 20.");
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		unsubscribe(append(symbols, "@depth" + level + (updatePeriod == 100 ? "@100ms" : ""), AppendMode.LOWER_CASE));
	}
	
	public void subscribePartialDiffBookDepth(String symbol, int level, long updatePeriod) {
		if (level != 5 && level != 10 && level != 20)
			throw new IllegalArgumentException("level must be either 5, 10 or 20.");
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		subscribe(symbol.toLowerCase() + "@depth" + level + (updatePeriod == 100 ? "@100ms" : ""));
	}
	
	public void unsubscribePartialDiffBookDepth(String symbol, int level, long updatePeriod) {
		if (level != 5 && level != 10 && level != 20)
			throw new IllegalArgumentException("level must be either 5, 10 or 20.");
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		unsubscribe(symbol.toLowerCase() + "@depth" + level + (updatePeriod == 100 ? "@100ms" : ""));
	}
	
	public void subscribeDiffBookDepth(List<String> symbols, long updatePeriod) {
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		subscribe(append(symbols, "@depth" + (updatePeriod == 100 ? "@100ms" : ""), AppendMode.LOWER_CASE));
	}
	
	public void unsubscribeDiffBookDepth(List<String> symbols, long updatePeriod) {
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		unsubscribe(append(symbols, "@depth" + (updatePeriod == 100 ? "@100ms" : ""), AppendMode.LOWER_CASE));
	}
	
	public void subscribeDiffBookDepth(String symbol, long updatePeriod) {
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		subscribe(symbol.toLowerCase() + "@depth" + (updatePeriod == 100 ? "@100ms" : ""));
	}
	
	public void unsubscribeDiffBookDepth(String symbol, long updatePeriod) {
		if (updatePeriod != 1000 && updatePeriod != 100)
			throw new IllegalArgumentException("updatePeriod must be 100 or 1000.");
		unsubscribe(symbol.toLowerCase() + "@depth" + (updatePeriod == 100 ? "@100ms" : ""));
	}
	
	
	public void addOnTradeEvent(OnTrade onTrade) {
		this.onTrades.add(onTrade);
	}
	
	public void addOnAggTradeEvent(OnAggTrade onAggTrade) {
		this.onAggTrades.add(onAggTrade);
	}
	
	public void addOnCandleEvent(OnCandle onCandle) {
		this.onCandles.add(onCandle);
	}
	
	public void addOnTickerEvent(OnTicker onTicker) {
		this.onTickers.add(onTicker);
	}
	
	public void addOnMiniTickerEvent(OnMiniTicker onMiniTicker) {
		this.onMiniTickers.add(onMiniTicker);
	}
	
	public void addOnBookTickerEvent(OnBookTicker onBookTicker) {
		this.onBookTickers.add(onBookTicker);
	}
	
	public void addOnPartialDiffBook(OnPartialDiffBook onPartialDiffBook) {
		this.onPartialDiffBooks.add(onPartialDiffBook);
	}
	
	public void addOnDiffBook(OnDiffBook onDiffBook) {
		this.onDiffBooks.add(onDiffBook);
	}
	
	@Override
	public void clearEvents() {
		this.onTrades.clear();
		this.onAggTrades.clear();
		this.onCandles.clear();
		this.onTickers.clear();
		this.onMiniTickers.clear();
		this.onBookTickers.clear();
		this.onPartialDiffBooks.clear();
		this.onDiffBooks.clear();
	}

}
