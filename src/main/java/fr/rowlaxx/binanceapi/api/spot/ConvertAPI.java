package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.convert.ConvertRecord;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#convert-endpoints
 */
public interface ConvertAPI extends Api.Https, Api.Spot {

	//Get Convert Trade History (USER_DATA)
	@ApiEndpoint (
			endpoint = " /sapi/v1/convert/tradeFlow",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTimestamp, Parameters.endTimestamp, Parameters.limit},
			mandatory = {true, true, false}
	)
	@RedirectResponse(path = "list")
	public List<ConvertRecord> getConvertHistory(Long startTimestamp, Long endTimestamp, Integer limit);
}
