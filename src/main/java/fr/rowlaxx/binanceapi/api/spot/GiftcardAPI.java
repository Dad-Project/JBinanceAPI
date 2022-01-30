package fr.rowlaxx.binanceapi.api.spot;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.giftcard.Giftcard;
import fr.rowlaxx.binanceapi.core.giftcard.GiftcardRedemption;
import fr.rowlaxx.binanceapi.core.giftcard.GiftcardVerification;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#binance-code-endpoints
 */
public interface GiftcardAPI extends Api.Https, Api.Spot {

	//Create a Binance Code (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/giftcard/createCode",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.token, Parameters.amount},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data")
	public Giftcard create(String token, double amount);
	
	//Redeem a Binance Code (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/giftcard/redeemCode",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.code},
			mandatory = {true}
	)
	@RedirectResponse(path = "data")
	public GiftcardRedemption redeem(String code);
	
	//Verify a Binance Code (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/giftcard/verify",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.code},
			mandatory = {true}
	)
	@RedirectResponse(path = "data")
	public GiftcardVerification verify(String code);
}
