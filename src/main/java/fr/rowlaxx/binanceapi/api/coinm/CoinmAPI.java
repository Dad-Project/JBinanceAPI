package fr.rowlaxx.binanceapi.api.coinm;

public final class CoinmAPI {

	private final CoinmMarketDataAPI market;
	private final CoinmTradeAPI trade;
	
	public CoinmAPI(CoinmMarketDataAPI market, CoinmTradeAPI trade) {
		this.trade = trade;
		this.market = market;
	}
	
	public CoinmMarketDataAPI market() {
		return market;
	}
	
	public CoinmTradeAPI trade() {
		return trade;
	}
	
}
