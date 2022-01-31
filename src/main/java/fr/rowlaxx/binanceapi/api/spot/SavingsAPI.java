package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.savings.FlexibleProduct;
import fr.rowlaxx.binanceapi.core.savings.SavingsInterestRecord;
import fr.rowlaxx.binanceapi.core.savings.LendingAccount;
import fr.rowlaxx.binanceapi.core.savings.LendingTypes;
import fr.rowlaxx.binanceapi.core.savings.PurchaseRecord;
import fr.rowlaxx.binanceapi.core.savings.DailyPosition;
import fr.rowlaxx.binanceapi.core.savings.FixedPosition;
import fr.rowlaxx.binanceapi.core.savings.FixedProduct;
import fr.rowlaxx.binanceapi.core.savings.FixedTypes;
import fr.rowlaxx.binanceapi.core.savings.FlexiblePosition;
import fr.rowlaxx.binanceapi.core.savings.Quota;
import fr.rowlaxx.binanceapi.core.savings.RedemptionQuota;
import fr.rowlaxx.binanceapi.core.savings.RedemptionRecord;
import fr.rowlaxx.binanceapi.core.savings.SavingsPositionStatus;
import fr.rowlaxx.binanceapi.core.savings.SavingsRedemptionType;
import fr.rowlaxx.binanceapi.core.savings.SavingsSortBy;
import fr.rowlaxx.binanceapi.core.savings.SavingsStatus;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-28
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#savings-endpoints
 */
public interface SavingsAPI extends Api.Https, Api.Spot {

	//Get Flexible Product List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/product/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.status, Parameters.featured, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false}
	)
	public List<FlexibleProduct> getFlexibleProducts(SavingsStatus status, String featured, Long current, Long size);

	//Get Left Daily Purchase Quota of Flexible Product (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userLeftQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId},
			mandatory = {true}
	)
	public Quota getFlexibleProductQuota(String productId);

	//Purchase Flexible Product (USER_DATA)
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

	//Get Left Daily Redemption Quota of Flexible Product (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/userRedemptionQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.type},
			mandatory = {true, true}
	)
	public RedemptionQuota getFlexibleProductRedemptionQuota(String productId, SavingsRedemptionType type);

	//Redeem Flexible Product (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/redeem",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.productId, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	public void redeemFlexibleProduct(String productId, Double amount, SavingsRedemptionType type);

	//Get Flexible Product Position (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/daily/token/position",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public List<FlexiblePosition> getFlexibleProductPosition(String asset);

	//Get Fixed and Activity Project List(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.status, Parameters.isSortAsc, Parameters.sortBy, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false}
	)
	public List<FixedProduct> getFixedProducts(String asset, FixedTypes type, SavingsStatus status, Boolean isSortAsc, SavingsSortBy sortBy, Long current, Long size);

	//Purchase Fixed/Activity Project (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/customizedFixed/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "purchaseId")
	public long purchaseFixedProduct(String projectId, long lot);

	//Get Fixed/Activity Project Position (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/project/position/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.projectId, Parameters.status},
			mandatory = {true, false, false}
	)
	public List<FixedPosition> getFixedPosition(String asset, String projectId, SavingsPositionStatus status);

	//Lending Account (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public LendingAccount getLendingAccount();

	//Get Purchase Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/purchaseRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<PurchaseRecord> getPurchaseHistory(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	//Get Redemption Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/redemptionRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<RedemptionRecord> getRedemptionHistory(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	//Get Interest History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/union/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.lendingType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false, false}
	)
	public List<SavingsInterestRecord> getInterestHistory(LendingTypes lendingType, String asset, Long startTime, Long endTime, Long current, Long size);

	//Change Fixed/Activity Position to Daily Position(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/lending/positionChanged",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.projectId, Parameters.lot, Parameters.positionId},
			mandatory = {true, true, false}
	)
	public DailyPosition changeFixedToDailyPosition(String projectId, Long lot, Long positionId);
}