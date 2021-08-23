package fr.rowlaxx.binanceapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.api.spot.SpotCandlestick;
import fr.rowlaxx.binanceapi.core.market.Intervals;

public class Test {

	public static final String API_KEY = "ZaCevetiE3qBRZ3G21JMRVbq5qGINzpFhGCEOVapSy7Hvk8swcpDM5c2ZY55UHOG";
	public static final String API_SECRET = "1M1ZXUBaoDG4kYLrTLfcgVOeXuOrrz2l77mXLNjpe8AcQdPXYS3AOebviFPfjDMx";
	
	public static void main(String[] args) throws UnknownHostException, IOException, URISyntaxException, InterruptedException, ExecutionException {
				
		final BinanceClient client = BinanceClient.create(API_KEY, API_SECRET);
		client.login();
		
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder("/api/v3/ticker/24hr", Method.GET)
				.addParameter(Parameters.symbol, "BTCUSDT")
				.addSignature(false)
				.build();

			
		final JSONObject object = client.getHttpClient().execute(request);
		
		System.out.println(object.toString(2));
				
				
				
				
				
				
		System.exit(0);
		
		final List<String> symbols = new ArrayList<String>(client.spot().getExchangeInformation().getSymbols().keySet());
		symbols.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		
		boolean f = false;
		for (String symbol : symbols) {
			if (	!symbol.startsWith("BTC") && 
					!symbol.startsWith("BNB") && 
					!symbol.startsWith("ETH") && 
					!symbol.startsWith("XRP"))
				continue;
							
			for (Intervals interval : Intervals.values() ) {
				System.out.println("Getting infos for " + symbol + " at interval " + interval);

				final File file = new File("Spot" + File.separator + symbol + File.separator + interval.name() + ".data");
				file.getParentFile().mkdirs();
				
				if (file.exists())
					continue;
				
				try (final FileOutputStream fos = new FileOutputStream(file)){
					try (final ZipOutputStream zos = new ZipOutputStream(fos)){
						zos.setLevel(9);
						zos.setMethod(ZipOutputStream.DEFLATED);
						
						zos.putNextEntry(new ZipEntry("info"));
						try (final ObjectOutputStream oos = new ObjectOutputStream(zos)){
							oos.writeObject(symbol);
							oos.writeObject(interval);
							doSymbol(client, zos, oos, symbol, interval);
						}
					}
				}
			}
		}
		
	}
	
	private static void doSymbol(BinanceClient client, ZipOutputStream zos, ObjectOutputStream oos, String symbol, Intervals interval) throws IOException {
		final int step = 1000;
		long startTime = 0;
		List<SpotCandlestick> candles = null;
		
		while ((candles = client.spot().getCandlesticks(symbol, interval, startTime, null, step)).size() > 0) {
			for (SpotCandlestick candle : candles) {
				zos.putNextEntry(new ZipEntry(String.valueOf(candle.getOpenTime())));
				oos.writeObject(candle);
			}
			startTime = candles.get(candles.size()-1).getCloseTime();
			System.out.println("Retrieved : " + Instant.ofEpochMilli(startTime));
		}	
	}	
}