package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.pay.PayRecord;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints
 */
public interface PayAPI extends Api.Https, Api.Spot {

	//Get Pay Trade History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/pay/transactions",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTimestamp, Parameters.endTimestamp, Parameters.limit},
			mandatory = {false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<PayRecord> getPayTradeHistory(Long startTimestamp, Long endTimestamp, Integer limit);
	
	default List<PayRecord> getPayTradeHistory(Integer limit){
		return getPayTradeHistory(null, null, limit);
	}
	
}
