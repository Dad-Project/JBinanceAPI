@ApiEndpoint (
	endpoint = "/sapi/v1/mining/pub/algoList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public AcquiringAlgorithm getAcquiringAlgorithm();

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/pub/coinList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public AcquiringCoinName getAcquiringCoinName();

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/worker/detail",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName, Parameters.workerName},
	mandatory = {true, true, true}
}
public RequestforDetailMinerList getRequestforDetailMinerList(String algo, String userName, String workerName);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/worker/list",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName, Parameters.pageIndex, Parameters.sort, Parameters.sortColumn, Parameters.workerStatus},
	mandatory = {true, true, false, false, false, false}
}
public RequestforMinerList getRequestforMinerList(String algo, String userName, int pageIndex, int sort, int sortColumn, int workerStatus);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/payment/list",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName, Parameters.coin, Parameters.startDate, Parameters.endDate, Parameters.pageIndex, Parameters.pageSize},
	mandatory = {true, true, false, false, false, false, false}
}
public EarningsList getEarningsList(String algo, String userName, String coin, long startDate, long endDate, int pageIndex, int pageSize);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/payment/other",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName, Parameters.coin, Parameters.startDate, Parameters.endDate, Parameters.pageIndex, Parameters.pageSize},
	mandatory = {true, true, false, false, false, false, false}
}
public ExtraBonusList getExtraBonusList(String algo, String userName, String coin, long startDate, long endDate, int pageIndex, int pageSize);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/hash-transfer/config/details/list",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.pageIndex, Parameters.pageSize},
	mandatory = {false, false}
}
public HashrateResaleList getHashrateResaleList(int pageIndex, int pageSize);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/hash-transfer/profit/details",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.configId, Parameters.userName, Parameters.pageIndex, Parameters.pageSize},
	mandatory = {true, true, false, false}
}
public HashrateResaleDetail getHashrateResaleDetail(int configId, String userName, int pageIndex, int pageSize);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/hash-transfer/config",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.userName, Parameters.algo, Parameters.endDate, Parameters.startDate, Parameters.toPoolUser, Parameters.hashRate},
	mandatory = {true, true, true, true, true, true}
}
public HashrateResaleRequest postHashrateResaleRequest(String userName, String algo, long endDate, long startDate, String toPoolUser, long hashRate);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/hash-transfer/config/cancel",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.configId, Parameters.userName},
	mandatory = {true, true}
}
public Cancelhashrateresaleconfiguration postCancelhashrateresaleconfiguration(int configId, String userName);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/statistics/user/status",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName},
	mandatory = {true, true}
}
public StatisticList getStatisticList(String algo, String userName);

@ApiEndpoint (
	endpoint = "/sapi/v1/mining/statistics/user/list",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.algo, Parameters.userName},
	mandatory = {true, true}
}
public AccountList getAccountList(String algo, String userName);

