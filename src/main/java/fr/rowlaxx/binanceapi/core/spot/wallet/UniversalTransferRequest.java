package fr.rowlaxx.binanceapi.core.spot.wallet;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;

public class UniversalTransferRequest extends BinanceAutoHttpRequest {
	
	public UniversalTransferTypes type;
	public String asset;
	public double amount;
	public String fromSymbol;
	public String toSymbol;

}
