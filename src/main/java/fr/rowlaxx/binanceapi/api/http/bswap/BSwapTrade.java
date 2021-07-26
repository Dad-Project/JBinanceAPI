package fr.rowlaxx.binanceapi.api.http.bswap;

import java.util.Objects;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.enums.bswap.RemoveLiquidityOperationType;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

public interface BSwapTrade {

	//Add Liquidity (TRADE)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/liquidityAdd",
			needSignature = true,
			method = Method.POST,
			parameters = {Parameters.poolId, Parameters.asset, Parameters.quantity},
			mandatory = {true, true, true}
	)
	@JsonValue(nameInJson = "operationId")
	public long addLiquidity(long poolId, String asset, double quantity);
	
	//Remove Liquidity (TRADE)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/liquidityRemove",
			needSignature = true,
			method = Method.POST,
			parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
			mandatory = {true, true, false, true}
	)
	@JsonValue(nameInJson = "operationId")
	public long removeLiquidity(long poolId, RemoveLiquidityOperationType type, String asset, double shareAmount);
	
	default long removeLiquidity(long poolId, String asset, double shareAmount) {
		Objects.requireNonNull(asset, "asset may not be null.");
		return removeLiquidity(poolId, RemoveLiquidityOperationType.SINGLE, asset, shareAmount);
	}
	
	default long removeLiquidity(long poolId, double shareAmount) {
		return removeLiquidity(poolId, RemoveLiquidityOperationType.COMBINATION, null, shareAmount);
	}
	
	//Swap (TRADE)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/swap",
			needSignature = true,
			method = Method.POST,
			parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
			mandatory = {true, true, true}
	)
	@JsonValue(nameInJson = "swapId")
	public long swap(String quoteAsset, String baseAsset, double quoteQty) ;
}
