package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.future.AdjustCrossCollateral;
import fr.rowlaxx.binanceapi.core.future.AdjustCrossCollateralRecord;
import fr.rowlaxx.binanceapi.core.future.Borrow;
import fr.rowlaxx.binanceapi.core.future.BorrowRecord;
import fr.rowlaxx.binanceapi.core.future.CollateralRepayLimit;
import fr.rowlaxx.binanceapi.core.future.CollateralRepayQuote;
import fr.rowlaxx.binanceapi.core.future.CrossCollateralInformation;
import fr.rowlaxx.binanceapi.core.future.CrossCollateralInterestRecord;
import fr.rowlaxx.binanceapi.core.future.CrossCollateralLiquidationRecord;
import fr.rowlaxx.binanceapi.core.future.CrossCollateralWallet;
import fr.rowlaxx.binanceapi.core.future.Direction;
import fr.rowlaxx.binanceapi.core.future.MaxAmount;
import fr.rowlaxx.binanceapi.core.future.Repay;
import fr.rowlaxx.binanceapi.core.future.RepayRecord;
import fr.rowlaxx.binanceapi.core.order.BasicOrderStatus;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransfer;

public interface FuturesAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long futureAccountTransfer(String asset, double amount, int type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, true, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<UniversalTransfer> getFutureAccountTransferHistory(String asset, Long startTime, Long endTime, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/borrow",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.amount, Parameters.collateralCoin, Parameters.collateralAmount},
			mandatory = {true, true, true, true}
	)
	public Borrow borrowForCrossCollateral(String coin, double amount, String collateralCoin, double collateralAmount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/borrow/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<BorrowRecord> getCrossCollateralBorrowHistory(String coin, Long startTime, Long endTime, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
			mandatory = {true, true, true}
	)
	public Repay repayForCrossCollateral(String coin, String collateralCoin, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/repay/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<RepayRecord> getCrossCollateralRepaymentHistory(String coin, long startTime, long endTime, long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/wallet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossCollateralWallet getCrossCollateralWallet();

	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/wallet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossCollateralWallet getCrossCollateralWalletV2();

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/configs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin},
			mandatory = {false}
	)
	public List<CrossCollateralInformation> getCrossCollateralInformation(String collateralCoin);

	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/configs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin},
			mandatory = {false, false}
	)
	public List<CrossCollateralInformation> getCrossCollateralInformationV2(String loanCoin, String collateralCoin);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/calcAdjustLevel",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "afterCollateralRate")
	public double calculateRateAfterAdjustCrossCollateral(String collateralCoin, double amount, Direction direction);

	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/calcAdjustLevel",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "afterCollateralRate")
	public double calculateRateAfterAdjustCrossCollateralV2(String loanCoin, String collateralCoin, double amount, Direction direction);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/calcMaxAdjustAmount",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin},
			mandatory = {true}
	)
	public MaxAmount getMaxAmountForAdjustCrossCollateral(String collateralCoin);

	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/calcMaxAdjustAmount",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin},
			mandatory = {true, true}
	)
	public MaxAmount getMaxAmountForAdjustCrossCollateralV2(String loanCoin, String collateralCoin);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/adjustCollateral",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true}
	)
	public AdjustCrossCollateral adjustCrossCollateral(String collateralCoin, double amount, Direction direction);

	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/adjustCollateral",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true, true}
	)
	public AdjustCrossCollateral adjustCrossCollateralV2(String loanCoin, String collateralCoin, double amount, Direction direction);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/adjustCollateral/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<AdjustCrossCollateralRecord> getAdjustCrossCollateralHistory(String loanCoin, String collateralCoin, Long startTime, Long endTime, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/liquidationHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<CrossCollateralLiquidationRecord> getCrossCollateralLiquidationHistory(String loanCoin, String collateralCoin, Long startTime, Long endTime, Long limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepayLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin},
			mandatory = {true, true}
	)
	public CollateralRepayLimit getCollateralRepayLimit(String coin, String collateralCoin);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
			mandatory = {true, true, true}
	)
	public CollateralRepayQuote getCollateralRepayQuote(String coin, String collateralCoin, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.quoteId},
			mandatory = {true}
	)
	public CollateralRepayQuote repayWithCollateral(String quoteId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepayResult",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.quoteId},
			mandatory = {true}
	)
	@RedirectResponse(path = "status")
	public BasicOrderStatus getCollateralRepaymentResult(String quoteId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<CrossCollateralInterestRecord> getCrossCollateralInterestHistory(String collateralCoin, Long startTime, Long endTime, Long current, Long limit);
}