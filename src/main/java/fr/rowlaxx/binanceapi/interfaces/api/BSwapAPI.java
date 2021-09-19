package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.bswap.AddLiquidityPreview;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationRecord;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperations;
import fr.rowlaxx.binanceapi.core.bswap.PoolConfigure;
import fr.rowlaxx.binanceapi.core.bswap.PoolLiquidityInformation;
import fr.rowlaxx.binanceapi.core.bswap.RemoveLiquidityPreview;
import fr.rowlaxx.binanceapi.core.bswap.RequestQuote;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationTypes;
import fr.rowlaxx.binanceapi.core.bswap.Swap;
import fr.rowlaxx.binanceapi.core.general.bswap.SwapPool;

public interface BSwapAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/pools",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "poolId")
	public Map<Integer, SwapPool> getAllSwapPools();

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidity",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "poolId")
	public Map<Integer, PoolLiquidityInformation> getPoolLiquidityInformations();

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidity",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public PoolLiquidityInformation getPoolLiquidityInformation(long poolId);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityAdd",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.asset, Parameters.quantity},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "operationId")
	public long addLiquidity(long poolId, String asset, double quantity);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityRemove",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
			mandatory = {true, true, false, true},
			defaultValues = {"", "SINGLE", "", ""}
	)
	@RedirectResponse(path = "operationId")
	public long removeSingleLiquidity(long poolId, Collection<String> asset, double shareAmount);
	
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
			mandatory = {true, true, false, true},
			defaultValues = {"", "COMBINATION", "", ""}
	)
	@RedirectResponse(path = "operationId")
	public long removeCombinationLiquidity(long poolId, Collection<String> asset, double shareAmount);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/liquidityOps",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.operation, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<LiquidityOperationRecord> getLiquidityOperationRecords(Long poolId, LiquidityOperations operation, Long startTime, Long endTime, Long limit);

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

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/quote",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
			mandatory = {true, true, true}
	)
	public RequestQuote getRequestQuote(String quoteAsset, String baseAsset, double quoteQty);

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

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/swap",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.status, Parameters.quoteAsset, Parameters.baseAsset, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<Swap> getSwapHistory(Long startTime, Long endTime, LiquidityOperationStatus status, String quoteAsset, String baseAsset, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bswap/swap",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = Parameters.swapId,
			mandatory = true
	)
	@RedirectResponse(path = "%INDEX=0%")
	public Swap getSwap(Long swapId);
	
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
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/addLiquidityPreview",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.quoteAsset, Parameters.quoteQty},
			mandatory = {true, true, true, true}
	)
	public AddLiquidityPreview addLiquidityPreview(Long poolId, LiquidityOperationTypes type, String quoteAsset, Double quoteQty);

	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/removeLiquidityPreview",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.poolId, Parameters.type, Parameters.quoteAsset, Parameters.shareAmount},
			mandatory = {true, true, true, true}
	)
	public RemoveLiquidityPreview removeLiquidityPreview(Long poolId, LiquidityOperationTypes type, String quoteAsset, Double shareAmount);

}