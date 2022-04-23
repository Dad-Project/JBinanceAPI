package fr.rowlaxx.binanceapi.api.spot;

import java.util.Objects;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public class BLVTAPI {

	//Variables
	private final BinanceClient client;
	
	private BLVTHttpAPI http = null;
	private BLVTStreamAPI stream = null;
	
	//Constructeurs
	public BLVTAPI(BinanceClient client) {
		this.client = Objects.requireNonNull(client, "client may not be null.");
	}
	
	//Methodes
	public BLVTHttpAPI http() {
		if (http == null)
			http = ApiImplementer.implementz(BLVTHttpAPI.class, client);
		return http;
	}
	
	public BLVTStreamAPI stream() {
		if (stream == null)
			stream = new BLVTStreamAPI();
		return stream;
	}
	
}
