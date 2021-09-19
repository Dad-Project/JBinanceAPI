package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public interface SavingsAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/product/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.status, Parameters.featured, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false}
	)
	public List<GetFlexibleProductList> getGetFlexibleProductList(Enum status, String featured, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userLeftQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId},
			mandatory = {true}
	)
	public GetLeftDailyPurchaseQuotaofFlexibleProduct getGetLeftDailyPurchaseQuotaofFlexibleProduct(String productId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.amount},
			mandatory = {true, true}
	)
	public PurchaseFlexibleProduct postPurchaseFlexibleProduct(String productId, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userRedemptionQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.type},
			mandatory = {true, true}
	)
	public GetLeftDailyRedemptionQuotaofFlexibleProduct getGetLeftDailyRedemptionQuotaofFlexibleProduct(String productId, Enum type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/redeem",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	public void postRedeemFlexibleProduct(String productId, double amount, Enum type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/token/position",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public List<GetFlexibleProductPosition> getGetFlexibleProductPosition(String asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.status, Parameters.isSortAsc, Parameters.sortBy, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false}
	)
	public List<GetFixedandActivityProjectList> getGetFixedandActivityProjectList(String asset, Enum type, Enum status, boolean isSortAsc, Enum sortBy, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/customizedFixed/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot},
			mandatory = {true, true}
	)
	public PurchaseFixedActivityProject postPurchaseFixedActivityProject(String projectId, long lot);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/position/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.projectId, Parameters.status},
			mandatory = {true, false, false}
	)
	public List<GetFixedActivityProjectPosition> getGetFixedActivityProjectPosition(String asset, String projectId, Enum status);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public LendingAccount getLendingAccount();

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/purchaseRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetPurchaseRecord> getGetPurchaseRecord(Enum lendingType, String asset, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/purchaseRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetPurchaseRecord1> getGetPurchaseRecord1(Enum lendingType, String asset, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/redemptionRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetRedemptionRecord> getGetRedemptionRecord(Enum lendingType, String asset, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/redemptionRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetRedemptionRecord1> getGetRedemptionRecord1(Enum lendingType, String asset, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetInterestHistory> getGetInterestHistory(Enum lendingType, String asset, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/positionChanged",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot, Parameters.positionId},
			mandatory = {true, true, false}
	)
	public ChangeFixedActivityPositiontoDailyPosition postChangeFixedActivityPositiontoDailyPosition(String projectId, long lot, long positionId);
}