package fr.rowlaxx.binanceapi.interfaces.api.coinm;

public interface CoinmAPI extends CoinmAccountAPI, CoinmGeneralAPI, CoinmMarketDataAPI {

	default CoinmAccountAPI getAccountAPI() {
		return this;
	}
	
	default CoinmGeneralAPI getGeneralAPI() {
		return this;
	}
	
	default CoinmMarketDataAPI getMarketDataAPI() {
		return this;
	}	
}
