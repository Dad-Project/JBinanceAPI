package fr.rowlaxx.binanceapi.api.spot;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.bswap.AddLiquidityPreview;
import fr.rowlaxx.binanceapi.core.bswap.ClaimRecord;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationRecord;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationTypes;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperations;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityPreview;
import fr.rowlaxx.binanceapi.core.bswap.PoolConfigure;
import fr.rowlaxx.binanceapi.core.bswap.PoolLiquidity;
import fr.rowlaxx.binanceapi.core.bswap.RequestQuote;
import fr.rowlaxx.binanceapi.core.bswap.SwapRecord;
import fr.rowlaxx.binanceapi.core.bswap.UnclaimedRewards;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.binanceapi.core.bswap.SwapPool;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#bswap-endpoints
 */
public interface BSwapAPI extends Api.Https, Api.Spot {

	//List All Swap Pools (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/pools",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "poolId")
	public Map<Integer, SwapPool> getSwapPools();

	default SwapPool getSwapPool(Integer poolId) {
		return getSwapPools().get(poolId);
	}
	
	//Get liquidity information of a pool (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidity",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "poolId")
	public Map<Integer, PoolLiquidity> getPoolLiquidities();

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidity",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public PoolLiquidity getPoolLiquidity(long poolId);
	
	//Add Liquidity (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityAdd",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.quantity},
			mandatory = {true, false, true, true}
	)
	@RedirectResponse(path = "operationId")
	public long addLiquidity(long poolId, LiquidityOperationTypes type, String asset, double quantity);

	//Remove Liquidity (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityRemove",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
			mandatory = {true, true, false, true}
	)
	@RedirectResponse(path = "operationId")
	public long removeLiquidity(long poolId, LiquidityOperationTypes type, Collection<String> asset, double shareAmount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityRemove",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
			mandatory = {true, true, false, true}
	)
	@RedirectResponse(path = "operationId")
	public long removeLiquidity(long poolId, LiquidityOperationTypes type, String[] asset, double shareAmount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityRemove",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
			mandatory = {true, true, false, true}
	)
	@RedirectResponse(path = "operationId")
	public long removeLiquidity(long poolId, LiquidityOperationTypes type, String asset, double shareAmount);

	//Get Liquidity Operation Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityOps",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.operation, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<LiquidityOperationRecord> getLiquidityOperationHistory(Long poolId, LiquidityOperations operation, Long startTime, Long endTime, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityOps",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = Parameters.operationId,
			mandatory = true
	)
	@RedirectResponse(path = "%INDEX=0%")
	public LiquidityOperationRecord getLiquidityOperationRecord(long operationId);

	//Request Quote (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/quote",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
			mandatory = {true, true, true}
	)
	public RequestQuote getRequestQuote(String quoteAsset, String baseAsset, double quoteQty);

	//Swap (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/swap",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "swapId")
	public long swap(String quoteAsset, String baseAsset, double quoteQty);

	//Get Swap History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/swap",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.status, Parameters.quoteAsset, Parameters.baseAsset, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<SwapRecord> getSwapHistory(Long startTime, Long endTime, LiquidityOperationStatus status, String quoteAsset, String baseAsset, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/swap",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = Parameters.swapId,
			mandatory = true
	)
	@RedirectResponse(path = "%INDEX=0%")
	public SwapRecord getSwapRecord(Long swapId);
	
	//Get Pool Configure (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/poolConfigure",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "poolName")
	public Map<String, PoolConfigure> getPoolConfigures();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/poolConfigure",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public PoolConfigure getPoolConfigure(Long poolId);
	
	//Add Liquidity Preview (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/addLiquidityPreview",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.quoteAsset, Parameters.quoteQty},
			mandatory = {true, true, true, true}
	)
	public AddLiquidityPreview previewAddLiquidity(Long poolId, LiquidityOperationTypes type, String quoteAsset, Double quoteQty);

	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/removeLiquidityPreview",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.quoteAsset, Parameters.shareAmount},
			mandatory = {true, true, true, true}
	)
	public LiquidityPreview previewRemoveLiquidity(Long poolId, LiquidityOperationTypes type, String quoteAsset, Double shareAmount);

	//Get Unclaimed Rewards Record (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/unclaimedRewards",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type},
			mandatory = {true},
			defaultValues = {"0"}
	)
	public UnclaimedRewards getSwapUnclaimedRewards();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/unclaimedRewards",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type},
			mandatory = {true},
			defaultValues = {"1"}
	)
	public UnclaimedRewards getLiquidityUnclaimedRewards();
	
	//Get Claimed History (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/claimRewards",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.type},
			mandatory = {true},
			defaultValues = {"0"}
	)
	@RedirectResponse(path = "success")
	public boolean claimSwapRewards();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/claimRewards",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.type},
			mandatory = {true},
			defaultValues = {"1"}
	)
	@RedirectResponse(path = "success")
	public boolean claimLiquidityRewards();
	
	//Get Claimed History (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/claimedHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false},
			defaultValues = {"", "", "0", "", "", ""}
	)
	@RedirectResponse(path = "success")
	public List<ClaimRecord> getSwapClaimHistory(Long poolId, String asset, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/claimedHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false},
			defaultValues = {"", "", "1", "", "", ""}
	)
	@RedirectResponse(path = "success")
	public List<ClaimRecord> getLiquidityClaimHistory(Long poolId, String asset, Long startTime, Long endTime, Integer limit);
}