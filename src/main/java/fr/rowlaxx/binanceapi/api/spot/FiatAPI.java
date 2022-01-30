package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.fiat.FiatPaymentRecord;
import fr.rowlaxx.binanceapi.core.fiat.FiatTransferRecord;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#fiat-endpoints
 */
public interface FiatAPI extends Api.Https, Api.Spot {

	//Get Fiat Deposit/Withdraw History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/fiat/orders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false},
			defaultValues = {"0-deposit", "", "", "", ""}
	)
	@RedirectResponse(path = "data")
	public List<FiatTransferRecord> getDepositHistory(Long beginTime, Long endTime, Integer page, Integer rows);

	default List<FiatTransferRecord> getDepositHistory(Integer page, Integer rows) {
		return getDepositHistory(null, null, page, rows);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/fiat/orders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false},
			defaultValues = {"1-withdraw", "", "", "", ""}
	)
	@RedirectResponse(path = "data")
	public List<FiatTransferRecord> getWithdrawHistory(Long beginTime, Long endTime, Integer page, Integer rows);

	default List<FiatTransferRecord> getWithdrawHistory(Integer page, Integer rows) {
		return getWithdrawHistory(null, null, page, rows);
	}
	
	
	//Get Fiat Payments History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/fiat/payments",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false},
			defaultValues = {"0-buy", "", "", "", ""}
	)
	@RedirectResponse(path = "data")
	public List<FiatPaymentRecord> getBuyHistory(Long beginTime, Long endTime, Integer page, Integer rows);

	default List<FiatPaymentRecord> getBuyHistory(Integer page, Integer rows) {
		return getBuyHistory(null, null, page, rows);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/fiat/payments",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false},
			defaultValues = {"1-sell", "", "", "", ""}
	)
	@RedirectResponse(path = "data")
	public List<FiatPaymentRecord> getSellHistory(Long beginTime, Long endTime, Integer page, Integer rows);

	default List<FiatPaymentRecord> getSellHistory(Integer page, Integer rows) {
		return getSellHistory(null, null, page, rows);
	}
}