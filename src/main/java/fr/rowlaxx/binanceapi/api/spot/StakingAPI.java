package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.staking.StakingLeftQuota;
import fr.rowlaxx.binanceapi.core.staking.StakingPosition;
import fr.rowlaxx.binanceapi.core.staking.StakingProduct;
import fr.rowlaxx.binanceapi.core.staking.StakingProducts;
import fr.rowlaxx.binanceapi.core.staking.StakingRecord;
import fr.rowlaxx.binanceapi.core.staking.TxnTypes;
import fr.rowlaxx.convertutils.MapKey;

public interface StakingAPI extends Api.Https, Api.Spot {

	//Get Staking Product List(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/productList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.product, Parameters.asset, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false}
	)
	@MapKey(fieldName = "projectId")
	public Map<String, StakingProduct> getStakingProducts(StakingProducts product, String asset, Integer current, Integer size);

	//Purchase Staking Product(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.product, Parameters.productId, Parameters.amount, Parameters.renewable},
			mandatory = {true, true, true, false}
	)
	@RedirectResponse(path = "positionId")
	public int purchase(StakingProducts product, String productId, Double amount, Boolean renewable);

	//Redeem Staking Product(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/purchase",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.product, Parameters.positionId, Parameters.productId, Parameters.amount},
			mandatory = {true, false, true, false}
	)
	@RedirectResponse(path = "success")
	public int redeem(StakingProducts product, String positionId, String productId, Double amount);

	//Get Staking Product Position(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/position",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.product, Parameters.productId, Parameters.asset, Parameters.current, Parameters.size},
			mandatory = {true, false, false, false, false}
	)
	public List<StakingPosition> getStakingPositions(StakingProducts product, String productId, String asset, Integer current, Integer size);

	//Get Staking History(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/stakingRecord",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.product, Parameters.txnType, Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, true, false, false, false, false, false}
	)
	public List<StakingRecord> getStakingHistory(StakingProducts product, TxnTypes txnType , String asset, Long startTime, Long endTime, Integer current, Integer size);

	//Set Auto Staking(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/setAutoStaking",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.product, Parameters.positionId, Parameters.renewable},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "success")
	public boolean setAutoStaking(StakingProducts product, String positionId, boolean renewable);

	
	//Get Personal Left Quota of Staking Product(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/staking/personalLeftQuota",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.product, Parameters.productId},
			mandatory = {true, true}
	)
	public List<StakingLeftQuota> getPersonalLeftQuote(StakingProducts product, String productId);

}
