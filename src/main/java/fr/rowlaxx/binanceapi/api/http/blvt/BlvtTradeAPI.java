package fr.rowlaxx.binanceapi.api.http.blvt;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtRedemptionResult;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtSubscriptionResult;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public interface BlvtTradeAPI {

	//Subscribe BLVT (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/subscribe",
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.cost},
			mandatory = {true, true}
	)
	public BlvtSubscriptionResult subscribeBlvt(String tokenName, double cost);
	
	//Redeem BLVT (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/redeem",
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.amount},
			mandatory = {true, true}
	)
	public BlvtRedemptionResult redeemBlvt(String tokenName, double cost);
	
}
