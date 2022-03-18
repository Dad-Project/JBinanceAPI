package fr.rowlaxx.binanceapi.api.spot;

public final class SpotAPI {

	private final SpotMarketDataAPI market;
	private final SpotTradeAPI trade;
	
	public SpotAPI(SpotMarketDataAPI market, SpotTradeAPI trade) {
		this.trade = trade;
		this.market = market;
	}
	
	public SpotMarketDataAPI market() {
		return market;
	}
	
	public SpotTradeAPI trade() {
		return trade;
	}
}
