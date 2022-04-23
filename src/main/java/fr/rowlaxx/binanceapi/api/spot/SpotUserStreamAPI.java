package fr.rowlaxx.binanceapi.api.spot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.websocket.StreamAPI;
import fr.rowlaxx.binanceapi.core.Asset;
import fr.rowlaxx.binanceapi.core.spot.userstream.BalanceUpdate;
import fr.rowlaxx.binanceapi.core.spot.userstream.OrderUpdate;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.convertutils.MapKeyType;
import fr.rowlaxx.jsavon.Jsavon;
import fr.rowlaxx.utils.ParameterizedClass;

public class SpotUserStreamAPI extends StreamAPI implements Api.Spot {

	//Methodes
	private static String getListenKey(BinanceHttpClient httpClient, String endpoint) {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.GET)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.build();
		
		try {
			return ((JSONObject)httpClient.execute(request)).getString("listenKey");
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	
	private static void putListenKey(BinanceHttpClient httpClient, String endpoint, String listenKey) {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.PUT)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.addParameter(Parameters.listenKey, listenKey)
				.build();
		
		try {
			httpClient.execute(request);
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	
	private static void deleteListenKey(BinanceHttpClient httpClient, String endpoint, String listenKey) {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.DELETE)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.addParameter(Parameters.listenKey, listenKey)
				.build();
		
		try {
			httpClient.execute(request);
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	
	//Interfaces
	public static interface OnAccountUpdate {
		public void onAccountUpdate(long lastUpdate, Map<String, Asset> account);
	}
	
	public static interface OnBalanceUpdate {
		public void onBalanceUpdate(BalanceUpdate update);
	}
	
	public static interface OnOrderUpdate {
		public void onOrderUpdate(OrderUpdate update);
	}
	
	//Variables
	private final BinanceHttpClient httpClient;
	private final String endpoint;
	
	private final List<OnAccountUpdate> onAccountUpdate = new LinkedList<>();
	private final List<OnBalanceUpdate> onBalanceUpdate = new LinkedList<>();
	private final List<OnOrderUpdate> onOrderUpdate = new LinkedList<>();
	
	//Constructeurs
	public SpotUserStreamAPI(BinanceHttpClient httpClient, String endpoint) {
		super("wss://stream.binance.com:9443", getListenKey(httpClient, endpoint));
		this.endpoint = endpoint;
		this.httpClient = httpClient;
	}

	@Override
	public void clearEvents() {
		this.onAccountUpdate.clear();
		this.onBalanceUpdate.clear();
		this.onOrderUpdate.clear();
	}

	@Override
	protected void onJson(JSONObject json) {
		final String eventType = json.optString("e", null);
		
		if ("outboundAccountPosition".equals(eventType)) {
			final Map<String, Asset> map = Jsavon.converter.convert(json.get("B"), MapKeyType.from("asset", ParameterizedClass.from(Map.class, String.class, Asset.class)));
			final long lastUpdate = json.getLong("u");
			for (OnAccountUpdate event : onAccountUpdate)
				event.onAccountUpdate(lastUpdate, map);
		}
		else if ("balanceUpdate".equals(eventType)) {
			final BalanceUpdate update = Jsavon.converter.convert(json, BalanceUpdate.class);
			for (OnBalanceUpdate event : onBalanceUpdate)
				event.onBalanceUpdate(update);
		}
		else if ("executionReport".equals(eventType)) {
			final OrderUpdate update = Jsavon.converter.convert(json, OrderUpdate.class);
			for (OnOrderUpdate event : onOrderUpdate)
				event.onOrderUpdate(update);
		}
	}
	
	@Override
	public void close() {
		deleteListenKey(httpClient, endpoint, getListenKey());
		super.close();
	}
	
	public void addOnAccountUpdateEvent(OnAccountUpdate event) {
		if (event == null)
			return;
		this.onAccountUpdate.add(event);
	}
	
	public void addOnBalanceUpdateEvent(OnBalanceUpdate event) {
		if (event == null)
			return;
		this.onBalanceUpdate.add(event);
	}
	
	public void addOnOrderUpdateEvent(OnOrderUpdate event) {
		if (event == null)
			return;
		this.onOrderUpdate.add(event);
	}
}