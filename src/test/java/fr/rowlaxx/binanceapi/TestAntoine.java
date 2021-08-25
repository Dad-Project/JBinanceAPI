package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.java_cup.internal.runtime.Symbol;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.coinm.CoinmExchangeInformation;
import fr.rowlaxx.binanceapi.core.api.coinm.CoinmSymbol;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.market.TickerPriceChangeStatistics;
import sun.jvm.hotspot.utilities.Interval;
import sun.security.action.GetBooleanAction;

public class TestAntoine {

	public static void main(String[] args) throws IOException {

		BinanceClient client = BinanceClient.create(Test.API_KEY, Test.API_SECRET);
		client.login();
		
		/*Map<String, TickerPriceChangeStatistics> s = client.spot().get24hrTickersPriceChangeStatistics();
		TickerPriceChangeStatistics kk = s.get("BTCUSDT");
		System.out.println(kk);*/
		
		/*BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/api/v3/ticker/price", Method.GET)
				.addSignature(false)
				.addParameter(Parameters.symbol, "BTCUSDT")
				.build();
		JSONObject json = client.getHttpClient().execute(request);
		SymbolPriceTicker ticker = new SymbolPriceTicker(json);*/
	}

}
