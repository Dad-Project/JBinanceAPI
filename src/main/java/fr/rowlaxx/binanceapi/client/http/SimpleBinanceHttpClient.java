package fr.rowlaxx.binanceapi.client.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClientImpl;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpRequestException;
import fr.rowlaxx.binanceapi.utils.IOUtils;

class SimpleBinanceHttpClient {

	//Variables statiques
	public static final String APIKEY_HEADER = "X-MBX-APIKEY";

	//Variables
	private final BinanceClientImpl api;	
	private long defaultRecvWindow = 5_000;

	//Constructeurs
	public SimpleBinanceHttpClient(BinanceClientImpl api) {
		Objects.requireNonNull(api, "api may not be null.");
		if ( api.getHttpClient() != null )
			throw new IllegalArgumentException("this api already has a httpClient.");
		this.api = api;
	}
	
	//Methodes
	@SuppressWarnings("unchecked")
	public final <T> T execute(BinanceHttpRequest request) throws IOException {
		final HttpURLConnection con = openHttpURLConnection(request);

		try {
			con.connect();

			try {
				return (T) IOUtils.readAllAsJson(con.getInputStream());
			}catch(IOException e) {
				try {
					final Object object = IOUtils.readAllAsJson(con.getErrorStream());
					if (object instanceof JSONArray)
						return (T) object;

					final JSONObject json = (JSONObject) object;
					if (json.length() == 2 && json.has("code") && json.has("msg"))
						throw new BinanceHttpClientException(json.getString("msg"), json.getInt("code"));
					
					return (T) json;
				}catch(JSONException jsonException) {
					final int code = con.getResponseCode();
					final String message = con.getResponseMessage();
					
					if (message != null)
						throw new BinanceHttpClientException(message, code);
					if (code == 403)
						throw new BinanceHttpClientException("WAF (Web Application Firewall) has been violated.", code);
					if (code == 404)
						throw new BinanceHttpClientException("Page not found.", code);
					else if (code == 429)
						throw new BinanceHttpClientException("Breaking request rate limit.", code);
					else if (code == 418)
						throw new BinanceHttpClientException("This IP has been auto-banned for continuing to send requests after receiving 429 codes.", code);
					else if (code >= 400 && code < 500)
						throw new BinanceHttpClientException("Code " + code + " malformed request.", code);
					else if (code >= 500 && code < 600)
						throw new BinanceHttpClientException("Binance internal error. The execution status is UNKNOWN and could have been a success.", code);
					throw new BinanceHttpClientException("Unknow error", code);
				} catch(IOException e1) {
					request.getBaseEndpoint().next();
					throw e1;
				}
			}
		}finally {
			con.disconnect();
		}
	}
	
	public final <T> T executeWithRetry(BinanceHttpRequest request, int retry) throws IOException {
		for (int i = 0 ; i < retry ; i++)
			try {
				return execute(request);
			}catch(IOException e) {
				if (i+1 == retry)
					throw e;
			}
		throw new IllegalStateException();
	}

	public final <T> CompletableFuture<T> executeAsync(BinanceHttpRequest request, int retry){
		final CompletableFuture<T> response = new CompletableFuture<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					response.complete( executeWithRetry(request, retry) );
				}catch(Exception e) {
					response.completeExceptionally(e);
				}
			}
		}, "BinanceRequestProcessor").start();
		return response;
	}
	
	public final <T> CompletableFuture<T> executeAsync(BinanceHttpRequest request) {
		return executeAsync(request, 1);
	}
	
	private final HttpURLConnection openHttpURLConnection(BinanceHttpRequest request) {
		try {
			final URL url = getRequestURL(request);
			final HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//Set params
			con.setRequestMethod(request.getMethod().name());
			con.setReadTimeout( (int) (request.hasRecvWindow() ? request.getRecvWindow() : this.defaultRecvWindow) );
			con.setInstanceFollowRedirects(false);
			if ( !api.isGuest() )
				con.addRequestProperty(APIKEY_HEADER, api.getCredenticals().getApiKey() );

			return con;

		} catch (ProtocolException e) {
			throw new BinanceHttpRequestException("ProtecolException : " + e);
		} catch (MalformedURLException e) {
			throw new BinanceHttpRequestException("MalformedURLException : " + e);
		} catch (IOException e) {
			throw new BinanceHttpRequestException("IOException : " + e);
		}
	}
	
	private final URL getRequestURL(BinanceHttpRequest request) throws MalformedURLException {
		String baseEndpoint = request.getBaseEndpoint().toString();
		if (!baseEndpoint.endsWith("/"))
			baseEndpoint += "/";
		String endpoint = request.getEndpoint();
		if (endpoint.startsWith("/"))
			endpoint = endpoint.substring(1);
		if (endpoint.endsWith("/"))
			endpoint = endpoint.substring(0, endpoint.length()-1);
		String query = getQuery(request);
		if (!query.isEmpty())
			query = "?" + query;
		return new URL(baseEndpoint + endpoint + query);
	}
	
	private final String getQuery(BinanceHttpRequest request) {
		if (request.addSignature() )
			if (api.isGuest())
				throw new BinanceHttpRequestException("Cannot sign this request as a guest.");
			else if (!api.isLogged())
				throw new BinanceHttpRequestException("Cannot sign this request. The client has not been logged. (invalid apikey or apisecret).");

		final StringBuilder queryBuilder = new StringBuilder(256);

		//Parametre normaux
		for (Parameters param : request.getParameters().keySet() ) {
			if (queryBuilder.length() != 0)
				queryBuilder.append('&');
			queryBuilder.append(request.getTextParameters(param));
		}

		//Timestamp & recvWindow & Signature
		if ( request.addSignature() ) {
			if (queryBuilder.length() != 0)
				queryBuilder.append('&');
			queryBuilder.append(Parameters.timestamp + "=" + System.currentTimeMillis());
			queryBuilder.append('&');
			queryBuilder.append(Parameters.recvWindow + "=");
			queryBuilder.append( request.hasRecvWindow() ? request.getRecvWindow() : this.defaultRecvWindow );

			//Signature
			final String message = queryBuilder.toString();
			queryBuilder.append('&');
			queryBuilder.append(Parameters.signature);
			queryBuilder.append('=');
			queryBuilder.append(api.getCredenticals().signMessage(message));
		}

		return queryBuilder.toString();
	}

	//Getters
	public long getDefaultRecvWindow() {
		return defaultRecvWindow;
	}

	//Setters
	public void setDefaultRecvWindow(long defaultRecvWindow) {
		if (defaultRecvWindow <= 0 || defaultRecvWindow > 60000)
			throw new IllegalArgumentException("recvWindow must be between 1 and 60000.");
		this.defaultRecvWindow = defaultRecvWindow;
	}
}