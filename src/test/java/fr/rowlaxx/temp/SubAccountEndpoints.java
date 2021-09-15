@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/virtualSubAccount",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.subAccountString},
	mandatory = {false}
}
public CreateaVirtualSubaccount postCreateaVirtualSubaccount(String subAccountString);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/list",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.isFreeze, Parameters.page, Parameters.limit},
	mandatory = {false, false, false, false}
}
public QuerySubaccountList getQuerySubaccountList(String email, String isFreeze, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/sub/transfer/history",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
	mandatory = {false, false, false, false, false, false}
}
public List<QuerySubaccountSpotAssetTransferHistory> getQuerySubaccountSpotAssetTransferHistory(String fromEmail, String toEmail, long startTime, long endTime, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.futuresType, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
	mandatory = {true, true, false, false, false, false}
}
public QuerySubaccountFuturesAssetTransferHistory getQuerySubaccountFuturesAssetTransferHistory(String email, long futuresType, long startTime, long endTime, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.futuresType, Parameters.asset, Parameters.amount},
	mandatory = {true, true, true, true, true}
}
public SubaccountFuturesAssetTransfer postSubaccountFuturesAssetTransfer(String fromEmail, String toEmail, long futuresType, String asset, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v3/sub-account/assets",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public QuerySubaccountAssets getQuerySubaccountAssets(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/spotSummary",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.page, Parameters.size},
	mandatory = {false, false, false}
}
public QuerySubaccountSpotAssetsSummary getQuerySubaccountSpotAssetsSummary(String email, long page, long size);

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/deposit/subAddress",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.coin, Parameters.network},
	mandatory = {true, true, false}
}
public GetSubaccountDepositAddress getGetSubaccountDepositAddress(String email, String coin, String network);

@ApiEndpoint (
	endpoint = "/sapi/v1/capital/deposit/subHisrec",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.offset},
	mandatory = {true, false, false, false, false, false, false}
}
public List<GetSubaccountDepositHistory> getGetSubaccountDepositHistory(String email, String coin, int status, long startTime, long endTime, int limit, int offset);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/status",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {false}
}
public List<GetSubaccountsStatusonMarginFutures> getGetSubaccountsStatusonMarginFutures(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/margin/enable",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public EnableMarginforSubaccount postEnableMarginforSubaccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/margin/account",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public GetDetailonSubaccountsMarginAccount getGetDetailonSubaccountsMarginAccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/margin/accountSummary",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public GetSummaryofSubaccountsMarginAccount getGetSummaryofSubaccountsMarginAccount();

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/enable",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public EnableFuturesforSubaccount postEnableFuturesforSubaccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/account",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public GetDetailonSubaccountsFuturesAccount getGetDetailonSubaccountsFuturesAccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/accountSummary",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public GetSummaryofSubaccountsFuturesAccount getGetSummaryofSubaccountsFuturesAccount();

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/positionRisk",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public List<GetFuturesPositionRiskofSubaccount> getGetFuturesPositionRiskofSubaccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/futures/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
	mandatory = {true, true, true, true}
}
public FuturesTransferforSubaccount postFuturesTransferforSubaccount(String email, String asset, double amount, int type);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/margin/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
	mandatory = {true, true, true, true}
}
public MarginTransferforSubaccount postMarginTransferforSubaccount(String email, String asset, double amount, int type);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/transfer/subToSub",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.toEmail, Parameters.asset, Parameters.amount},
	mandatory = {true, true, true}
}
public TransfertoSubaccountofSameMaster postTransfertoSubaccountofSameMaster(String toEmail, String asset, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/transfer/subToMaster",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.amount},
	mandatory = {true, true}
}
public TransfertoMaster postTransfertoMaster(String asset, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/transfer/subUserHistory",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public List<SubaccountTransferHistory> getSubaccountTransferHistory(String asset, int type, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/universalTransfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.fromAccountType, Parameters.toAccountType, Parameters.asset, Parameters.amount},
	mandatory = {false, false, true, true, true, true}
}
public UniversalTransfer postUniversalTransfer(String fromEmail, String toEmail, String fromAccountType, String toAccountType, String asset, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/universalTransfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
	mandatory = {false, false, false, false, false, false}
}
public List<QueryUniversalTransferHistory> getQueryUniversalTransferHistory(String fromEmail, String toEmail, long startTime, long endTime, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/account",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.futuresType},
	mandatory = {true, true}
}
public GetDetailonSubaccountsFuturesAccountV2 getGetDetailonSubaccountsFuturesAccountV2(String email, int futuresType);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/account",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.futuresType},
	mandatory = {true, true}
}
public GetDetailonSubaccountsFuturesAccountV21 getGetDetailonSubaccountsFuturesAccountV21(String email, int futuresType);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/accountSummary",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.futuresType, Parameters.page, Parameters.limit},
	mandatory = {true, false, false}
}
public GetSummaryofSubaccountsFuturesAccountV2 getGetSummaryofSubaccountsFuturesAccountV2(int futuresType, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/accountSummary",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.futuresType, Parameters.page, Parameters.limit},
	mandatory = {true, false, false}
}
public GetSummaryofSubaccountsFuturesAccountV21 getGetSummaryofSubaccountsFuturesAccountV21(int futuresType, int page, int limit);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/positionRisk",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.futuresType},
	mandatory = {true, true}
}
public GetFuturesPositionRiskofSubaccountV2 getGetFuturesPositionRiskofSubaccountV2(String email, int futuresType);

@ApiEndpoint (
	endpoint = "/sapi/v2/sub-account/futures/positionRisk",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email, Parameters.futuresType},
	mandatory = {true, true}
}
public GetFuturesPositionRiskofSubaccountV21 getGetFuturesPositionRiskofSubaccountV21(String email, int futuresType);

@ApiEndpoint (
	endpoint = "/sapi/v1/sub-account/blvt/enable",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.email, Parameters.enableBlvt},
	mandatory = {true, true}
}
public EnableLeverageTokenforSubaccount postEnableLeverageTokenforSubaccount(String email, boolean enableBlvt);

@ApiEndpoint (
	endpoint = "/sapi/v1/managed-subaccount/deposit",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.toEmail, Parameters.asset, Parameters.amount},
	mandatory = {true, true, true}
}
public DepositassetsintothemanagedsubaccountForInvestorMasterAccount postDepositassetsintothemanagedsubaccountForInvestorMasterAccount(String toEmail, String asset, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/managed-subaccount/asset",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.email},
	mandatory = {true}
}
public List<QuerymanagedsubaccountassetdetailsForInvestorMasterAccount> getQuerymanagedsubaccountassetdetailsForInvestorMasterAccount(String email);

@ApiEndpoint (
	endpoint = "/sapi/v1/managed-subaccount/withdraw",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.fromEmail, Parameters.asset, Parameters.amount, Parameters.transferDate},
	mandatory = {true, true, true, false}
}
public WithdrawlassetsfromthemanagedsubaccountForInvestorMasterAccount postWithdrawlassetsfromthemanagedsubaccountForInvestorMasterAccount(String fromEmail, String asset, double amount, long transferDate);

