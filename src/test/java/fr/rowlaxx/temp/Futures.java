@ApiEndpoint (
	endpoint = "/sapi/v1/futures/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.amount, Parameters.type},
	mandatory = {true, true, true}
}
public NewFutureAccountTransfer postNewFutureAccountTransfer(String asset, double amount, int type);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/transfer",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
	mandatory = {true, true, false, false, false}
}
public GetFutureAccountTransactionHistoryList getGetFutureAccountTransactionHistoryList(String asset, long startTime, long endTime, long current, long size);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/borrow",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.amount, Parameters.collateralCoin, Parameters.collateralAmount},
	mandatory = {true, true, true, true}
}
public BorrowForCrossCollateral postBorrowForCrossCollateral(String coin, double amount, String collateralCoin, double collateralAmount);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/borrow/history",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false}
}
public CrossCollateralBorrowHistory getCrossCollateralBorrowHistory(String coin, long startTime, long endTime, long limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/repay",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
	mandatory = {true, true, true}
}
public RepayForCrossCollateral postRepayForCrossCollateral(String coin, String collateralCoin, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/repay/history",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false}
}
public CrossCollateralRepaymentHistory getCrossCollateralRepaymentHistory(String coin, long startTime, long endTime, long limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/wallet",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public CrossCollateralWallet getCrossCollateralWallet();

@ApiEndpoint (
	endpoint = "/sapi/v2/futures/loan/wallet",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
}
public CrossCollateralWalletV2 getCrossCollateralWalletV2();

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/configs",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.collateralCoin},
	mandatory = {false}
}
public List<CrossCollateralInformation> getCrossCollateralInformation(String collateralCoin);

@ApiEndpoint (
	endpoint = "/sapi/v2/futures/loan/configs",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin},
	mandatory = {false, false}
}
public List<CrossCollateralInformationV2> getCrossCollateralInformationV2(String loanCoin, String collateralCoin);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/calcAdjustLevel",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
	mandatory = {true, true, true}
}
public CalculateRateAfterAdjustCrossCollateralLTV getCalculateRateAfterAdjustCrossCollateralLTV(String collateralCoin, double amount, Enum direction);

@ApiEndpoint (
	endpoint = "/sapi/v2/futures/loan/calcAdjustLevel",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
	mandatory = {true, true, true, true}
}
public CalculateRateAfterAdjustCrossCollateralLTVV2 getCalculateRateAfterAdjustCrossCollateralLTVV2(String loanCoin, String collateralCoin, double amount, Enum direction);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/calcMaxAdjustAmount",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.collateralCoin},
	mandatory = {true}
}
public GetMaxAmountforAdjustCrossCollateralLTV getGetMaxAmountforAdjustCrossCollateralLTV(String collateralCoin);

@ApiEndpoint (
	endpoint = "/sapi/v2/futures/loan/calcMaxAdjustAmount",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin},
	mandatory = {true, true}
}
public GetMaxAmountforAdjustCrossCollateralLTVV2 getGetMaxAmountforAdjustCrossCollateralLTVV2(String loanCoin, String collateralCoin);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/adjustCollateral",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
	mandatory = {true, true, true}
}
public AdjustCrossCollateralLTV postAdjustCrossCollateralLTV(String collateralCoin, double amount, Enum direction);

@ApiEndpoint (
	endpoint = "/sapi/v2/futures/loan/adjustCollateral",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
	mandatory = {true, true, true, true}
}
public AdjustCrossCollateralLTVV2 postAdjustCrossCollateralLTVV2(String loanCoin, String collateralCoin, double amount, Enum direction);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/adjustCollateral/history",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public AdjustCrossCollateralLTVHistory getAdjustCrossCollateralLTVHistory(String loanCoin, String collateralCoin, long startTime, long endTime, long limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/liquidationHistory",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public CrossCollateralLiquidationHistory getCrossCollateralLiquidationHistory(String loanCoin, String collateralCoin, long startTime, long endTime, long limit);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/collateralRepayLimit",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.collateralCoin},
	mandatory = {true, true}
}
public CheckCollateralRepayLimit getCheckCollateralRepayLimit(String coin, String collateralCoin);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/collateralRepay",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
	mandatory = {true, true, true}
}
public GetCollateralRepayQuote getGetCollateralRepayQuote(String coin, String collateralCoin, double amount);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/collateralRepay",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.quoteId},
	mandatory = {true}
}
public RepaywithCollateral postRepaywithCollateral(String quoteId);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/collateralRepayResult",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.quoteId},
	mandatory = {true}
}
public CollateralRepaymentResult getCollateralRepaymentResult(String quoteId);

@ApiEndpoint (
	endpoint = "/sapi/v1/futures/loan/interestHistory",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.limit},
	mandatory = {false, false, false, false, false}
}
public CrossCollateralInterestHistory getCrossCollateralInterestHistory(String collateralCoin, long startTime, long endTime, long current, long limit);

