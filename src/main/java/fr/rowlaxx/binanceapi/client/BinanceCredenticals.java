package fr.rowlaxx.binanceapi.client;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class BinanceCredenticals {

	//Variables
	private final String apiKey, apiSecret;
	
	//Constructeurs
	public BinanceCredenticals(final String apiKey, final String apiSecret) {
		Objects.requireNonNull(apiKey, "apiKey should not be null.");
		Objects.requireNonNull(apiSecret, "apiSecret should not be null.");
		
		if (apiKey.equalsIgnoreCase(apiSecret))
			throw new IllegalArgumentException("apiKey must not be equals to apiSecret.");
		
		if (apiKey.length() != 64)
			throw new IllegalArgumentException("apiKey must be 64 characters long.");
		if (apiSecret.length() != 64)
			throw new IllegalArgumentException("apiSecret must be 64 characters long.");
		if (!apiKey.matches("[\\w]*") )
			throw new IllegalArgumentException("apiKey is in an incorect format.");
		if (!apiSecret.matches("[\\w]*"))
			throw new IllegalArgumentException("apiSecret is in an incorect format.");
		
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}
	
	//Methodes
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
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException();//This should never been thrown
		} catch (InvalidKeyException e) {
			throw new RuntimeException();//This should never been thrown
		}
	}
	
	public String signMessage(String message) {
		return sign(message, apiSecret);
	}
	
	//Getters
	public String getApiKey() {
		return apiKey;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}
}