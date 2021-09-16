package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.wallet.fiat.FiatPaymentRecord;
import fr.rowlaxx.binanceapi.core.wallet.fiat.FiatTransferRecord;

public interface FiatAPI {

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
	public List<FiatTransferRecord> getFiatDepositHistory(Long beginTime, Long endTime, Integer page, Integer rows);

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
	public List<FiatTransferRecord> getFiatWithdrawHistory(Long beginTime, Long endTime, Integer page, Integer rows);

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
	public List<FiatPaymentRecord> getFiatBuyHistory(Long beginTime, Long endTime, Integer page, Integer rows);

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
	public List<FiatPaymentRecord> getFiatSellHistory(Long beginTime, Long endTime, Integer page, Integer rows);
}