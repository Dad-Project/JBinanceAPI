@ApiEndpoint (
	endpoint = "/sapi/v1/c2c/orderMatch/listUserOrderHistory",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.tradeType, Parameters.startTimestamp, Parameters.endTimestamp, Parameters.page, Parameters.rows},
	mandatory = {true, false, false, false, false}
)
public GetC2CTradeHistory getGetC2CTradeHistory(String tradeType, long startTimestamp, long endTimestamp, int page, int rows);

