package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.order.blvt.RedemptionRecord;
import fr.rowlaxx.binanceapi.core.savings.FixedActivityPositionToDailyPosition;
import fr.rowlaxx.binanceapi.core.savings.FixedActivityProjectPosition;
import fr.rowlaxx.binanceapi.core.savings.FixedAndActivityProject;
import fr.rowlaxx.binanceapi.core.savings.FixedTypes;
import fr.rowlaxx.binanceapi.core.savings.FlexibleProduct;
import fr.rowlaxx.binanceapi.core.savings.FlexibleProductPosition;
import fr.rowlaxx.binanceapi.core.savings.InterestRecord;
import fr.rowlaxx.binanceapi.core.savings.LeftDailyPurchaseQuota;
import fr.rowlaxx.binanceapi.core.savings.LeftDailyRedemptionQuota;
import fr.rowlaxx.binanceapi.core.savings.LendingAccount;
import fr.rowlaxx.binanceapi.core.savings.LendingTypes;
import fr.rowlaxx.binanceapi.core.savings.PurchaseRecord;
import fr.rowlaxx.binanceapi.core.savings.SavingsPositionStatus;
import fr.rowlaxx.binanceapi.core.savings.SavingsRedemptionType;
import fr.rowlaxx.binanceapi.core.savings.SavingsSortBy;
import fr.rowlaxx.binanceapi.core.savings.SavingsStatus;

public interface SavingsAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/product/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.status, Parameters.featured, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false}
	)
	public List<FlexibleProduct> getFlexibleProductList(SavingsStatus status, String featured, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userLeftQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId},
			mandatory = {true}
	)
	public LeftDailyPurchaseQuota getLeftDailyPurchaseQuotaOfFlexibleProduct(String productId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.amount},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "purchaseId")
	public long purchaseFlexibleProduct(String productId, Double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userRedemptionQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.type},
			mandatory = {true, true}
	)
	public LeftDailyRedemptionQuota getLeftDailyRedemptionQuotaOfFlexibleProduct(String productId, SavingsRedemptionType type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/redeem",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	public void redeemFlexibleProduct(String productId, Double amount, SavingsRedemptionType type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/token/position",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public List<FlexibleProductPosition> getFlexibleProductPositions(String asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.status, Parameters.isSortAsc, Parameters.sortBy, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false}
	)
	public List<FixedAndActivityProject> getFixedAndActivityProjects(String asset, FixedTypes type, SavingsStatus status, Boolean isSortAsc, SavingsSortBy sortBy, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/customizedFixed/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "purchaseId")
	public long purchaseFixedActivityProject(String projectId, long lot);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/position/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.projectId, Parameters.status},
			mandatory = {true, false, false}
	)
	public List<FixedActivityProjectPosition> getFixedActivityProjectPositions(String asset, String projectId, SavingsPositionStatus status);

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
	public List<PurchaseRecord> getGetPurchaseRecord(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/redemptionRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<RedemptionRecord> getGetRedemptionRecord(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<InterestRecord> getInterestHistory(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/positionChanged",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot, Parameters.positionId},
			mandatory = {true, true, false}
	)
	public FixedActivityPositionToDailyPosition changeFixedActivityPositionToDailyPosition(String projectId, Long lot, Long positionId);
}