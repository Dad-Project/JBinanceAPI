package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.general.blvt.BLVTInfo;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.market.blvt.BlvtCandlestick;
import fr.rowlaxx.binanceapi.core.order.blvt.Redemption;
import fr.rowlaxx.binanceapi.core.order.blvt.RedemptionRecord;
import fr.rowlaxx.binanceapi.core.order.blvt.Subscribtion;
import fr.rowlaxx.binanceapi.core.order.blvt.SubscriptionRecord;
import fr.rowlaxx.binanceapi.core.wallet.blvt.BLVTUserLimitInfo;

public interface BLVTAPI {
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/tokenInfo",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "tokenName")
	public Map<String, BLVTInfo> getGetBLVTInfos();

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/tokenInfo",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.tokenName},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public BLVTInfo getGetBLVTInfo(String tokenName);

	@ApiEndpoint (
			endpoint = "/fapi/v1/lvtKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<BlvtCandlestick> getCandlesticks(String asset, Intervals interval, Long startTime, Long endTime, Integer limit);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.cost},
			mandatory = {true, true}
	)
	public Subscribtion subscribeBLVT(String tokenName, double cost);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<SubscriptionRecord> getSubscriptionRecords(String tokenName, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/subscribe/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.id},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public SubscriptionRecord getSubscriptionRecords(Long id);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.amount},
			mandatory = {true, true}
	)
	public Redemption redeemBLVT(String tokenName, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<RedemptionRecord> getRedemptionRecords(String tokenName, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/redeem/record",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.id},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public RedemptionRecord getRedemptionRecords(Long id);

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/userLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "tokenName")
	public Map<String, BLVTUserLimitInfo> getBLVTUserLimitInfos();

	@ApiEndpoint (
			endpoint = "/sapi/v1/blvt/userLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tokenName},
			mandatory = {false}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public BLVTUserLimitInfo getBLVTUserLimitInfo(String tokenName);
}