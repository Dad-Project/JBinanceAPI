package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.blvt.BLVTInfo;
import fr.rowlaxx.binanceapi.core.blvt.BlvtUserLimit;
import fr.rowlaxx.binanceapi.core.blvt.BlvtCandlestick;
import fr.rowlaxx.binanceapi.core.blvt.Redemption;
import fr.rowlaxx.binanceapi.core.blvt.RedemptionRecord;
import fr.rowlaxx.binanceapi.core.blvt.Subscribtion;
import fr.rowlaxx.binanceapi.core.blvt.SubscriptionRecord;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints
 */
public interface BLVTAPI extends Api.Https, Api.Spot {
	
	//Get BLVT Info (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/tokenInfo",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "tokenName")
	public Map<String, BLVTInfo> getBLVTInfos();

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/tokenInfo",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.tokenName},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public BLVTInfo getBLVTInfo(String tokenName);

	//Historical BLVT NAV Kline/Candlestick
	@ApiEndpoint (
			endpoint = "/fapi/v1/lvtKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<BlvtCandlestick> getCandlesticks(String asset, Intervals interval, Long startTime, Long endTime, Integer limit);
	
	default List<BlvtCandlestick> getCandlesticks(String asset, Intervals interval, Integer limit){
		return getCandlesticks(asset, interval, null, null, limit);
	}
	
	//Subscribe BLVT (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.cost},
			mandatory = {true, true}
	)
	public Subscribtion subscribe(String tokenName, double cost);

	//Query Subscription Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<SubscriptionRecord> getSubscriptionHistory(String tokenName, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.id},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public SubscriptionRecord getSubscriptionRecord(Long id);

	//Redeem BLVT (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.amount},
			mandatory = {true, true}
	)
	public Redemption redeem(String tokenName, double amount);

	//Query Redemption Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<RedemptionRecord> getRedemptionHistory(String tokenName, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.id},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public RedemptionRecord getRedemptionRecord(Long id);

	//Get BLVT User Limit Info (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/userLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "tokenName")
	public Map<String, BlvtUserLimit> getUserLimitInfos();

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/userLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName},
			mandatory = {false}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public BlvtUserLimit getUserLimitInfo(String tokenName);
}