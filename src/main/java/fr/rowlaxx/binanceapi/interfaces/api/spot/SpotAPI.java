package fr.rowlaxx.binanceapi.interfaces.api.spot;

public interface SpotAPI extends SpotAccountAPI, SpotMarketDataAPI, SpotGeneralAPI, SpotWalletAPI {

	default SpotAccountAPI getAccountAPI() {
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
