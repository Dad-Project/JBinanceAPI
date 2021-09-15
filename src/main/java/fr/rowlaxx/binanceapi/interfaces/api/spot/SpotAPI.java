package fr.rowlaxx.binanceapi.interfaces.api.spot;

public interface SpotAPI extends SpotTradeAPI, SpotMarketDataAPI, SpotGeneralAPI, SpotWalletAPI {

	default SpotTradeAPI getTradeAPI() {
		return this;
	}
	
	default SpotGeneralAPI getGeneralAPI() {
		return this;
	}
	
	default SpotMarketDataAPI getMarketDataAPI() {
		return this;
	}
	
	default SpotWalletAPI getWalletAPI() {
		return this;
	}
}
