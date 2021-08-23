package fr.rowlaxx.binanceapi.client.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.utils.IOUtils;

public class BinanceHttpClient {

	//Variables statiques
	public static final String APIKEY_HEADER = "X-MBX-APIKEY";
	public static final String SPOT_BASE_ENDPOINT = "https://api.binance.com";
	public static final String FUTURE_USD_BASE_ENDPOINT = "https://fapi.binance.com";
	public static final String FUTURE_COIN_BASE_ENDPOINT = "https://dapi.binance.com";
	public static final String VANILLA_BASE_ENDPOINT = "https://vapi.binance.com";

	//Variables
	private final BinanceClient api;	
	private long defaultRecvWindow = 5_000;
	private String defaultBaseEndpoint = SPOT_BASE_ENDPOINT;

	//Constructeurs
	public BinanceHttpClient(BinanceClient api) {
		Objects.requireNonNull(api, "api may not be null.");
		if ( api.getHttpClient() != null )
			throw new IllegalArgumentException("this api already has a httpClient.");
		this.api = api;
	}

	//Methodes
	public final <T> T execute(ApiEndpoint endpoint, Object... params) throws IOException {
		if (params == null)
			params = new Object[] {};

		verifyEndpoint(endpoint, params);
		final BinanceHttpRequest.Builder builder = BinanceHttpRequest.newBuilder();
		builder.addSignature(endpoint.needSignature());
		builder.setBaseEndpoint(endpoint.baseEndpoint());
		builder.setEndpoint(endpoint.endpoint());
		builder.setMethod(endpoint.method());

		Object value;
		Parameters parameter;
		for (int i = 0 ; i < params.length ; i++) {
			value = params[i];
			parameter = endpoint.parameters()[i];
			builder.setParameter(parameter, value);
		}

		final BinanceHttpRequest request = builder.build();
		return executeWithRetry(request, 5);
	}

	private final static void verifyEndpoint(ApiEndpoint endpoint, Object[] params) {
		//Préliminaires
		Objects.requireNonNull(endpoint, "endpoint may not be null.");
		Objects.requireNonNull(params, "params may not be null.");
		if (params.length != endpoint.parameters().length)
			throw new ApiEndpointException("parameters and params must have the same size.");

		//On vérifie la taille des tableaux
		if (endpoint.parameters().length != endpoint.mandatory().length)
			throw new ApiEndpointException("parameters and mandatory do not have the same size.");

		//On vérifie qu'il n'y a pas de doublon.
		final HashSet<Parameters> set = new HashSet<>();
		for (Parameters parameter : endpoint.parameters()) {
			Objects.requireNonNull(parameter, "a null parameter has been found.");
			if (!set.add(parameter))
				throw new ApiEndpointException("A duplicated parameters has been found in the endpoint.");
		}

		//On vérifie les paramètres mandatoires
		for (int i = 0 ; i < params.length ; i++)
			if (params[i] == null && endpoint.mandatory()[i])
				throw new ApiEndpointException("The parameters " + endpoint.parameters()[i] + " is mandatory.");
	}
	
	public final <T> T executeWithRetry(BinanceHttpRequest request, int retry) throws IOException {
		for (int i = 0 ; i < retry ; i++)
			try {
				return execute(request);
			}catch(IOException | NullPointerException e) {
				if (i+1 == retry)
					throw e;
			}
		throw new IllegalStateException();
	}

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
				}
			}
		}finally {
			con.disconnect();
		}
	}

	public final <T> CompletableFuture<T> executeAsync(BinanceHttpRequest request){
		final CompletableFuture<T> response = new CompletableFuture<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					response.complete( execute(request) );
				}catch(Exception e) {
					response.completeExceptionally(e);
				}
			}
		}, "BinanceRequestProcessor").start();
		return response;
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
				con.addRequestProperty(APIKEY_HEADER, api.getApiKey() );

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
		String baseEndpoint = request.hasBaseEndpoint() ? request.getBaseEndpoint() : this.defaultBaseEndpoint;
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


		final StringBuilder queryBuilder = new StringBuilder(100);

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
			final String secret = api.getApiSecret();
			final String message = queryBuilder.toString();
			queryBuilder.append('&');
			queryBuilder.append(Parameters.signature);
			queryBuilder.append('=');
			queryBuilder.append(sign(message,secret));
		}

		return queryBuilder.toString();
	}

	//Methodes statiques
	private static String sign(String message, String secret) {
		try {
			final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			final SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
			sha256_HMAC.init(secretKeySpec);
			final byte[] data = sha256_HMAC.doFinal(message.getBytes());
			final StringBuilder signature = new StringBuilder(data.length * 2);
			for (byte temp : data)
				signature.append( String.format("%02x", temp) );
			return signature.toString();
		} catch (Exception e) {
			throw new BinanceHttpRequestException("Unable to sign message." + e);
		}
	}

	//Getters
	public long getDefaultRecvWindow() {
		return defaultRecvWindow;
	}

	public String getDefaultBaseEndpoint() {
		return defaultBaseEndpoint;
	}

	//Setters
	public void setDefaultRecvWindow(long defaultRecvWindow) {
		if (defaultRecvWindow <= 0 || defaultRecvWindow > 60000)
			throw new IllegalArgumentException("recvWindow must be between 1 and 60000.");
		this.defaultRecvWindow = defaultRecvWindow;
	}

	public void setDefaultBaseEndpoint(String defaultBaseEndpoint) {
		this.defaultBaseEndpoint = defaultBaseEndpoint;
	}
}