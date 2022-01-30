package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.rebate.RebateRecord;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints
 */
public interface RebateAPI extends Api.Https, Api.Spot {

	//Get Spot Rebate History Records (USER_DATA)
	@ApiEndpoint (
			endpoint = " /sapi/v1/rebate/taxQuery",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.page},
			mandatory = {false, false, false}
	)
	@RedirectResponse(path = "data/data")
	public List<RebateRecord> getSpotRebateHistory(Long startTimestamp, Long endTimestamp, Integer page);
	
	default List<RebateRecord> getSpotRebateHistory(Integer page){
		return getSpotRebateHistory(null, null, page);
	}
}
