package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;

abstract class TransferRequest extends BinanceAutoHttpRequest {

	public String coin;
	public Long startTime;
	public Long endTime;
	public Integer limit;
	public Integer offset;
	public Integer status;
	
}
