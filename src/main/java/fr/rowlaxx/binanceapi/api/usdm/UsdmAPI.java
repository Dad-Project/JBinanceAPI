package fr.rowlaxx.binanceapi.api.usdm;

public final class UsdmAPI {

	private final UsdmMarketDataAPI market;
	private final UsdmTradeAPI trade;
	
	public UsdmAPI(UsdmMarketDataAPI market, UsdmTradeAPI trade) {
		this.trade = trade;
		this.market = market;
	}
	
	public UsdmMarketDataAPI market() {
		return market;
	}
	
	public UsdmTradeAPI trade() {
		return trade;
	}	
}
