package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.websocket.BinanceWebSocket;
import fr.rowlaxx.binanceapi.client.websocket.BinanceWebSocketListener;
import fr.rowlaxx.binanceapi.core.general.Filters;
import fr.rowlaxx.binanceapi.core.general.filters.LotSizeFilter;
import fr.rowlaxx.binanceapi.core.general.filters.PriceFilter;
import fr.rowlaxx.binanceapi.core.general.usdm.UsdmExchangeInformation;
import fr.rowlaxx.binanceapi.core.general.usdm.UsdmSymbol;
import fr.rowlaxx.binanceapi.core.order.OrderSide;
import fr.rowlaxx.binanceapi.core.order.TimeInForce;
import fr.rowlaxx.binanceapi.core.order.future.FutureOrderTypes;

public class Test {

	public static final String API_KEY = "ZaCevetiE3qBRZ3G21JMRVbq5qGINzpFhGCEOVapSy7Hvk8swcpDM5c2ZY55UHOG";
	public static final String API_SECRET = "1M1ZXUBaoDG4kYLrTLfcgVOeXuOrrz2l77mXLNjpe8AcQdPXYS3AOebviFPfjDMx";
	
	public static final double TRADE_SIZE = 12.0;
	public static final long TRADE_COUNTDOWN = 30_000;
	public static final double MAX_TRADE_SIZE = 15.0;
	
	public static void main(String[] args) throws UnknownHostException, IOException, URISyntaxException, InterruptedException, ExecutionException {
				
		final BinanceClient client = BinanceClient.create(API_KEY, API_SECRET);
		client.login();
		client.getHttpClient().setDefaultRecvWindow(3000);
		
		final BinanceHttpRequest usdmRequest = BinanceHttpRequest.newBuilder()
				.setEndpoint("/fapi/v1/exchangeInfo")
				.setMethod(Method.GET)
				.setBaseEndpoint(BaseEndpoints.FUTURE_USD.getUrls().get(0))
				.addSignature(false)
				.build();
		
		final BinanceHttpRequest coimRequest = BinanceHttpRequest.newBuilder()
				.setEndpoint("/dapi/v1/exchangeInfo")
				.setMethod(Method.GET)
				.setBaseEndpoint(BaseEndpoints.FUTURE_COIN.getUrls().get(0))
				.addSignature(false)
				.build();
		
		final JSONObject usdmResponse = client.getHttpClient().executeWithRetry(usdmRequest, 5);
		final UsdmExchangeInformation usdmExchangeInformation = new UsdmExchangeInformation(usdmResponse);
						
		final BinanceWebSocket socket = new BinanceWebSocket("wss://fstream.binance.com", "test" + new Random().nextLong(), new BinanceWebSocketListener() {
		
			private long lastTrade = 0;
			
			@Override
			public void onJson(BinanceWebSocket socket, JSONObject json) {
				try {
					final Ticker ticker = new Ticker(json);
					final double price = (ticker.getAskPrice() + ticker.getBidPrice()) / 2;
					final double spread = ticker.getAskPrice() - ticker.getBidPrice();
					final double percent = (spread * 100) / price;
					
					if (System.currentTimeMillis() <= lastTrade + TRADE_COUNTDOWN)
						return;
					
					if (percent >= 0.20) {
						System.out.println("=".repeat(50));
						System.out.println("Placing trade on  " + ticker.getSymbol() +"...");
						final UsdmSymbol symbol = usdmExchangeInformation.getSymbol(ticker.getSymbol());
						if (placeUsdmTrade(client, ticker, symbol))
							lastTrade = System.currentTimeMillis();
					}
				}catch(Throwable e) {
					e.printStackTrace();
				}
			}
		});
		
		socket.subscribe("!bookTicker");
	}	
	
	private static boolean placeUsdmTrade(final BinanceClient client, final Ticker ticker, final UsdmSymbol symbol) throws IOException, InterruptedException, ExecutionException {
		final BinanceHttpRequest buy = buildRequest(symbol, ticker, OrderSide.BUY);
		if (buy == null)
			return false;
		final BinanceHttpRequest sell = buildRequest(symbol, ticker, OrderSide.SELL);
		
		ticker.print();
		CompletableFuture<Object> a = client.getHttpClient().executeAsync(buy, 2);
		CompletableFuture<Object> b = client.getHttpClient().executeAsync(sell, 2);
		
		System.out.println(a.get());
		System.out.println(b.get());
		
		return true;
	}
	
	private static BinanceHttpRequest buildRequest(UsdmSymbol symbol, Ticker ticker, OrderSide side) {
		final BinanceHttpRequest.Builder builder = BinanceHttpRequest.newBuilder()
				.setEndpoint("/fapi/v1/order")
				.setMethod(Method.POST)
				.setBaseEndpoint(BaseEndpoints.FUTURE_USD.getUrls().get(0))
				.addSignature(true)
				.addParameter(Parameters.timeInForce, TimeInForce.GTC)
				.addParameter(Parameters.symbol, symbol.getSymbol())
				.addParameter(Parameters.side, side)
				.addParameter(Parameters.type, FutureOrderTypes.LIMIT);
		
		final PriceFilter priceFilter = symbol.getFilter(Filters.PRICE_FILTER);
		final double tickSize = priceFilter.getTickSize();
		final int tickPrecision = (int) Math.round( -Math.log10(tickSize) );
		final double price = (ticker.getAskPrice() + ticker.getBidPrice()) / 2;
		final double stepSize = ((LotSizeFilter)symbol.getFilter(Filters.LOT_SIZE)).getStepSize();

		if (price * stepSize > MAX_TRADE_SIZE) {
			System.out.println("Cannot place a trade with only " + MAX_TRADE_SIZE + " usd.");
			return null;
		}
		
		if (side == OrderSide.BUY)
			builder.addParameter(Parameters.price, String.format(Locale.US, "%." + tickPrecision + "f", ticker.getBidPrice()+tickSize));
		else
			builder.addParameter(Parameters.price, String.format(Locale.US, "%." + tickPrecision + "f", ticker.getAskPrice()-tickSize));
		
		
		final double quantity = TRADE_SIZE / price;
		final int precision = (int) Math.round( -Math.log10(stepSize) );
		final String quantityStr = String.format(Locale.US, "%." + precision + "f", quantity);
		builder.addParameter(Parameters.quantity, quantityStr);
		return builder.build();
	}
}