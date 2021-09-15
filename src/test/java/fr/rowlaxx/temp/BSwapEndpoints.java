@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/pools",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {},
	mandatory = {}
}
public List<ListAllSwapPools> getListAllSwapPools();

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/liquidity",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.poolId},
	mandatory = {false}
}
public List<Getliquidityinformationofapool> getGetliquidityinformationofapool(long poolId);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/liquidityAdd",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.poolId, Parameters.asset, Parameters.quantity},
	mandatory = {true, true, true}
}
public AddLiquidity postAddLiquidity(long poolId, String asset, double quantity);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/liquidityRemove",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.poolId, Parameters.type, Parameters.asset, Parameters.shareAmount},
	mandatory = {true, true, false, true}
}
public RemoveLiquidity postRemoveLiquidity(long poolId, String type, List<Object> asset, double shareAmount);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/liquidityOps",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.operationId, Parameters.poolId, Parameters.operation, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false, false}
}
public List<GetLiquidityOperationRecord> getGetLiquidityOperationRecord(long operationId, long poolId, Enum operation, long startTime, long endTime, long limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/quote",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
	mandatory = {true, true, true}
}
public RequestQuote getRequestQuote(String quoteAsset, String baseAsset, double quoteQty);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/swap",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.quoteAsset, Parameters.baseAsset, Parameters.quoteQty},
	mandatory = {true, true, true}
}
public Swap postSwap(String quoteAsset, String baseAsset, double quoteQty);

@ApiEndpoint (
	endpoint = "/sapi/v1/bswap/swap",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.swapId, Parameters.startTime, Parameters.endTime, Parameters.status, Parameters.quoteAsset, Parameters.baseAsset, Parameters.limit},
	mandatory = {false, false, false, false, false, false, false}
}
public List<GetSwapHistory> getGetSwapHistory(long swapId, long startTime, long endTime, int status, String quoteAsset, String baseAsset, long limit);

