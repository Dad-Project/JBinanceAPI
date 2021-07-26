package fr.rowlaxx.binanceapi.api.http.bswap;

import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.core.api.bswap.SwapPool;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;

public interface BSwapMarketData {

	//List All Swap Pools (MARKET_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/bswap/pools",
			needSignature = false
	)
	@JsonMap(key = "poolId") 
	public Map<Long, SwapPool> getSwapPools();
	
	default SwapPool getSwapPool(long id) {
		return getSwapPools().get(id);
	}
}
