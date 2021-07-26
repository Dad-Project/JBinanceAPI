package fr.rowlaxx.binanceapi.api.http.bswap;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.bswap.DetailledSwapPool;
import fr.rowlaxx.binanceapi.core.api.bswap.SwapPoolOperationRecord;
import fr.rowlaxx.binanceapi.core.api.bswap.SwapQuote;
import fr.rowlaxx.binanceapi.core.api.bswap.SwapRecord;
import fr.rowlaxx.binanceapi.enums.bswap.LiquidityOperation;
import fr.rowlaxx.binanceapi.enums.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;

public interface BSwapUserData {

	//Get liquidity information of a pool (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/liquidity",
			needSignature = true
	)
	@JsonMap(key = "poolId")
	public Map<Long, DetailledSwapPool> getSwapPoolsLiquidityInfos();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/liquidity",
			needSignature = true,
			method = Method.GET,
			parameters = Parameters.poolId,
			mandatory = true
	)
	public DetailledSwapPool getSwapPoolLiquidityInfos(long poolId);
	
	//Get Liquidity Operation Record (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/liquidityOps",
			needSignature = true,
			parameters = {Parameters.operationId, Parameters.poolId, Parameters.operation, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long operationId, Long poolId, LiquidityOperation operation, Long startTime, Long endTime, Integer limit) {
		if (limit != null)
			if (limit <= 0 || limit > 100)
				throw new IllegalArgumentException("limit must be between 0 and 100. limit=" + limit);
		return null;
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long poolId, LiquidityOperation operation, Long startTime, Long endTime, Integer limit){
		return getLiquidityOperationRecords(null, poolId, operation, startTime, endTime, limit);
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long poolId, LiquidityOperation operation, Integer limit){
		return getLiquidityOperationRecords(null, poolId, operation, null, null, limit);
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long poolId, LiquidityOperation operation){
		return getLiquidityOperationRecords(null, poolId, operation, null, null, null);
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long poolId, Integer limit){
		return getLiquidityOperationRecords(null, poolId, null, null, null, limit);
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords(Long poolId){
		return getLiquidityOperationRecords(null, poolId, null, null, null, null);
	}
	
	default List<SwapPoolOperationRecord> getLiquidityOperationRecords() {
		return getLiquidityOperationRecords(null, null, null, null, null, null);
	}
	
	default SwapPoolOperationRecord getLiquidityOperationRecord(long operationId) {
		try{
			return getLiquidityOperationRecords(operationId, null, null, null, null, null).get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	//Request Quote (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/quote",
			needSignature = true,
			parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
			mandatory = {true, true, true}
	)
	public SwapQuote requestSwapQuote(String quoteAsset, String baseAsset, double quoteQty);
	
	//Get Swap History (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/swap",
			needSignature = true,
			parameters = {Parameters.swapId, Parameters.startTime, Parameters.endTime, Parameters.status, Parameters.quoteAsset, Parameters.baseAsset, Parameters.limit},
			mandatory = {false, false, false, false, false, false, false}
	)
	public default List<SwapRecord> getSwapHistory(Long swapId, Long startTime, Long endTime, LiquidityOperationStatus status, String quoteAsset, String baseAsset, Integer limit){
		if (limit != null)
			if (limit <= 0 || limit > 100)
				throw new IllegalArgumentException("limit must be between 0 and 100. limit=" + limit);
		return null;
	}
	
	public default List<SwapRecord> getSwapHistory(Long startTime, Long endTime, LiquidityOperationStatus status, String quoteAsset, String baseAsset, Integer limit){
		return getSwapHistory(null, startTime, endTime, status, quoteAsset, baseAsset, limit);
	}
	
	public default List<SwapRecord> getSwapHistory(LiquidityOperationStatus status, String quoteAsset, String baseAsset, Integer limit){
		return getSwapHistory(null, null, null, status, quoteAsset, baseAsset, limit);
	}
	
	public default List<SwapRecord> getSwapHistory(String quoteAsset, String baseAsset, Integer limit){
		return getSwapHistory(null, null, null, null, quoteAsset, baseAsset, limit);
	}
	
	public default List<SwapRecord> getSwapHistory(String quoteAsset, String baseAsset){
		return getSwapHistory(null, null, null, null, quoteAsset, baseAsset, null);
	}
	
	public default SwapRecord getSwapRecord(long swapId) {
		try {
			return getSwapHistory(swapId, null, null, null, null, null, null).get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
}
