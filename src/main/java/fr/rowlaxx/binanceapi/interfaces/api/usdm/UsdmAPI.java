package fr.rowlaxx.binanceapi.interfaces.api.usdm;

public interface UsdmAPI extends UsdmAccountAPI, UsdmGeneralAPI, UsdmMarketDataAPI {

	default UsdmAccountAPI getAccountAPI() {
		return this;
	}
	
	default UsdmGeneralAPI getGeneralAPI() {
		return this;
	}
	
	default UsdmMarketDataAPI getMarketDataAPI() {
		return this;
	}	
}
