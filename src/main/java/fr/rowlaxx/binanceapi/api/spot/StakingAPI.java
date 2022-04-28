package fr.rowlaxx.binanceapi.api.spot;

import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.staking.StakingProduct;
import fr.rowlaxx.binanceapi.core.staking.StakingProducts;
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
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.product, Parameters.productId, Parameters.amount, Parameters.renewable},
			mandatory = {true, true, true, false}
	)
	@RedirectResponse(path = "positionId")
	public int purchase(StakingProducts product, String productId, Double amount, Boolean renewable);

}
