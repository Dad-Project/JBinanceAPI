package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;

public class UniversalTransferRequest extends BinanceAutoHttpRequest {

	public UniversalTransferTypes type;
	public Long startTime;
	public Long endTime;
	public Integer current;
	public Integer size;
	public String fromSymbol;
	public String toSymbol;
	
}
