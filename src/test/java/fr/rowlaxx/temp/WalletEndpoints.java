@ApiEndpoint (
	endpoint = "/sapi/v1/system/status",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {},
	mandatory = {}
}
public SystemStatus getSystemStatus();

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/config/getall",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public List<AllCoinsInformation> getAllCoinsInformation();

@ApiEndpoint (
	endpoint = "/sapi/v1/accountSnapshot",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, false, false, false}
}
public DailyAccountSnapshot getDailyAccountSnapshot(String type, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/accountSnapshot",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, false, false, false}
}
public DailyAccountSnapshot1 getDailyAccountSnapshot1(String type, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/accountSnapshot",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, false, false, false}
}
public DailyAccountSnapshot2 getDailyAccountSnapshot2(String type, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/account/disableFastWithdrawSwitch",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public void postDisableFastWithdrawSwitch();

@ApiEndpoint (
	endpoint = "/sapi/v1/account/enableFastWithdrawSwitch",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public void postEnableFastWithdrawSwitch();

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/withdraw/apply",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.network, Parameters.address, Parameters.addressTag, Parameters.amount, Parameters.transactionFeeFlag, Parameters.name},
	mandatory = {true, false, false, true, false, true, false, false}
}
public Withdraw postWithdraw(String coin, String withdrawOrderId, String network, String address, String addressTag, double amount, boolean transactionFeeFlag, String name);

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/deposit/hisrec",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.offset, Parameters.limit},
	mandatory = {false, false, false, false, false, false}
}
public List<DepositHistory> getDepositHistory(String coin, int status, long startTime, long endTime, int offset, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/withdraw/history",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.status, Parameters.offset, Parameters.limit, Parameters.startTime, Parameters.endTime},
	mandatory = {false, false, false, false, false, false, false}
}
public List<WithdrawHistory> getWithdrawHistory(String coin, String withdrawOrderId, int status, int offset, int limit, long startTime, long endTime);

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/deposit/address",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.network},
	mandatory = {true, false}
}
public DepositAddress getDepositAddress(String coin, String network);

@ApiEndpoint (
	endpoint = "/sapi/v1/account/status",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public AccountStatus getAccountStatus();

@ApiEndpoint (
	endpoint = "/sapi/v1/account/apiTradingStatus",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public AccountAPITradingStatus getAccountAPITradingStatus();

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/dribblet",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.startTime, Parameters.endTime},
	mandatory = {false, false}
}
public DustLog getDustLog(long startTime, long endTime);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/dust",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.asset},
	mandatory = {true}
}
public DustTransfer postDustTransfer(Object[] asset);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/assetDividend",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false}
}
public AssetDividendRecord getAssetDividendRecord(String asset, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/assetDetail",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.asset},
	mandatory = {false}
}
public AssetDetail getAssetDetail(String asset);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/tradeFee",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public List<TradeFee> getTradeFee(String symbol);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.type, Parameters.asset, Parameters.amount, Parameters.fromSymbol, Parameters.toSymbol},
	mandatory = {true, true, true, false, false}
}
public UserUniversalTransfer postUserUniversalTransfer(Enum type, String asset, double amount, String fromSymbol, String toSymbol);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.fromSymbol, Parameters.toSymbol},
	mandatory = {true, false, false, false, false, false, false}
}
public QueryUserUniversalTransferHistory getQueryUserUniversalTransferHistory(Enum type, long startTime, long endTime, int current, int size, String fromSymbol, String toSymbol);

@ApiEndpoint (
	endpoint = "/sapi/v1/asset/get-funding-asset",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.needBtcValuation},
	mandatory = {false, false}
}
public List<FundingWallet> postFundingWallet(String asset, String needBtcValuation);

@ApiEndpoint (
	endpoint = "/sapi/v1/account/apiRestrictions",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public GetAPIKeyPermission getGetAPIKeyPermission();

