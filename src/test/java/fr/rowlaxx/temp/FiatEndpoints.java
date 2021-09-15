@ApiEndpoint (
	endpoint = "/sapi/v1/fiat/orders",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
	mandatory = {true, false, false, false, false}
}
public GetFiatDepositWithdrawHistory getGetFiatDepositWithdrawHistory(String transactionType, long beginTime, long endTime, int page, int rows);

@ApiEndpoint (
	endpoint = "/sapi/v1/fiat/payments",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.transactionType, Parameters.beginTime, Parameters.endTime, Parameters.page, Parameters.rows},
	mandatory = {true, false, false, false, false}
}
public GetFiatPaymentsHistory getGetFiatPaymentsHistory(String transactionType, long beginTime, long endTime, int page, int rows);

