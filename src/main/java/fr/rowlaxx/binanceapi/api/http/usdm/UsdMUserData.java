package fr.rowlaxx.binanceapi.api.http.usdm;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

public interface UsdMUserData {

	@ApiEndpoint(
			endpoint = "/fapi/v1/multiAssetsMargin",
			baseEndpoint = "",
			method = Method.GET,
			parameters = {},
			mandatory = {},
			needSignature = true
	)
	public boolean getCurrentMultiAssetsMode();
	
}
