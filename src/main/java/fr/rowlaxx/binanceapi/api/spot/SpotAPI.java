package fr.rowlaxx.binanceapi.api.spot;

public final class SpotAPI {

	private final SpotMarketDataAPI market;
	private final SpotTradeAPI trade;
	private SpotMarketDataStreamAPI stream;
	
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
	
	public SpotMarketDataStreamAPI stream() {
		if (stream == null)
			stream = new SpotMarketDataStreamAPI();
		return stream;
	}
}
