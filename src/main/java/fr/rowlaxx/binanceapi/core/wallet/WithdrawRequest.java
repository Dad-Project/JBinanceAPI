package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;

public class WithdrawRequest extends BinanceAutoHttpRequest {
	
	public String coin;
	public String withdrawOrderId;
	public String network;
	public String address;
	public String addressTag;
	public Double amount;
	public Boolean transactionFeeFlag;
	public String name;
	
}
