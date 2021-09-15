@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/tokenInfo",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.tokenName},
	mandatory = {false}
}
public List<GetBLVTInfo> getGetBLVTInfo(String tokenName);

@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/subscribe",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.tokenName, Parameters.cost},
	mandatory = {true, true}
}
public SubscribeBLVT postSubscribeBLVT(String tokenName, double cost);

@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/subscribe/record",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.tokenName, Parameters.id, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public List<QuerySubscriptionRecord> getQuerySubscriptionRecord(String tokenName, long id, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/redeem",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.tokenName, Parameters.amount},
	mandatory = {true, true}
}
public RedeemBLVT postRedeemBLVT(String tokenName, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/redeem/record",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.tokenName, Parameters.id, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public List<QueryRedemptionRecord> getQueryRedemptionRecord(String tokenName, long id, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/blvt/userLimit",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.tokenName},
	mandatory = {false}
}
public List<GetBLVTUserLimitInfo> getGetBLVTUserLimitInfo(String tokenName);

