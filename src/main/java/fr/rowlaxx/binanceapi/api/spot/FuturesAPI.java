package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.OrderStatus;
import fr.rowlaxx.binanceapi.core.futures.Adjustment;
import fr.rowlaxx.binanceapi.core.futures.AdjustmentRecord;
import fr.rowlaxx.binanceapi.core.futures.Borrow;
import fr.rowlaxx.binanceapi.core.futures.BorrowRecord;
import fr.rowlaxx.binanceapi.core.futures.CrossCollateralInformation;
import fr.rowlaxx.binanceapi.core.futures.CrossCollateralLiquidationRecord;
import fr.rowlaxx.binanceapi.core.futures.CrossCollateralWallet;
import fr.rowlaxx.binanceapi.core.futures.Directions;
import fr.rowlaxx.binanceapi.core.futures.FuturesInterestRecord;
import fr.rowlaxx.binanceapi.core.futures.MaxAmount;
import fr.rowlaxx.binanceapi.core.futures.Repay;
import fr.rowlaxx.binanceapi.core.futures.RepayLimit;
import fr.rowlaxx.binanceapi.core.futures.RepayQuote;
import fr.rowlaxx.binanceapi.core.futures.RepayRecord;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransfer;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#futures
 */
public interface FuturesAPI extends Api.Https, Api.Spot {

	//New Future Account Transfer (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long futureTransfer(String asset, double amount, int type);

	//Get Future Account Transaction History List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {true, true, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<UniversalTransfer> getTransferHistory(String asset, Long startTime, Long endTime, Long current, Long size);

	//Borrow For Cross-Collateral (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/borrow",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.amount, Parameters.collateralCoin, Parameters.collateralAmount},
			mandatory = {true, true, true, true}
	)
	public Borrow borrow(String coin, double amount, String collateralCoin, double collateralAmount);

	//Cross-Collateral Borrow History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/borrow/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<BorrowRecord> getBorrowHistory(String coin, Long startTime, Long endTime, Long limit);

	//Repay For Cross-Collateral (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
			mandatory = {true, true, true}
	)
	public Repay repay(String coin, String collateralCoin, double amount);

	//Cross-Collateral Repayment History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/repay/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<RepayRecord> getRepaymentHistory(String coin, long startTime, long endTime, long limit);

	//Cross-Collateral Wallet (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/wallet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossCollateralWallet getWallet();

	//Cross-Collateral Wallet V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/wallet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossCollateralWallet getWalletV2();

	//Cross-Collateral Information (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/configs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<CrossCollateralInformation> getInformations();

	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/configs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public CrossCollateralInformation getInformation(String collateralCoin);
	
	//Cross-Collateral Information V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/configs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin},
			mandatory = {false, false}
	)
	public List<CrossCollateralInformation> getInformationsV2(String loanCoin, String collateralCoin);

	default List<CrossCollateralInformation> getInformationsV2(){
		return getInformationsV2(null, null);
	}
	
	//Calculate Rate After Adjust Cross-Collateral LTV (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/calcAdjustLevel",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "afterCollateralRate")
	public double calculateRateAfterAdjustment(String collateralCoin, double amount, Directions direction);

	//Calculate Rate After Adjust Cross-Collateral LTV V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/calcAdjustLevel",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "afterCollateralRate")
	public double calculateRateAfterAdjustmentV2(String loanCoin, String collateralCoin, double amount, Directions direction);

	//Get Max Amount for Adjust Cross-Collateral LTV (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/calcMaxAdjustAmount",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin},
			mandatory = {true}
	)
	public MaxAmount getMaxAmountForAdjustment(String collateralCoin);

	//Get Max Amount for Adjust Cross-Collateral LTV V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/calcMaxAdjustAmount",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin},
			mandatory = {true, true}
	)
	public MaxAmount getMaxAmountForAdjustmentV2(String loanCoin, String collateralCoin);

	//Adjust Cross-Collateral LTV (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/adjustCollateral",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true}
	)
	public Adjustment adjust(String collateralCoin, double amount, Directions direction);

	//Adjust Cross-Collateral LTV V2 (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v2/futures/loan/adjustCollateral",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.amount, Parameters.direction},
			mandatory = {true, true, true, true}
	)
	public Adjustment adjustV2(String loanCoin, String collateralCoin, double amount, Directions direction);

	//Adjust Cross-Collateral LTV History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/adjustCollateral/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<AdjustmentRecord> getAdjustmentHistory(String loanCoin, String collateralCoin, Long startTime, Long endTime, Long limit);

	//Cross-Collateral Liquidation History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/liquidationHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.loanCoin, Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<CrossCollateralLiquidationRecord> getLiquidationHistory(String loanCoin, String collateralCoin, Long startTime, Long endTime, Long limit);

	//Check Collateral Repay Limit (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepayLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin},
			mandatory = {true, true}
	)
	public RepayLimit getRepayLimit(String coin, String collateralCoin);

	//Get Collateral Repay Quote (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.collateralCoin, Parameters.amount},
			mandatory = {true, true, true}
	)
	public RepayQuote getRepayQuote(String coin, String collateralCoin, double amount);

	//Repay with Collateral (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.quoteId},
			mandatory = {true}
	)
	public RepayQuote repay(String quoteId);

	//Collateral Repayment Result (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/collateralRepayResult",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.quoteId},
			mandatory = {true}
	)
	@RedirectResponse(path = "status")
	public OrderStatus getRepaymentResult(String quoteId);

	//Cross-Collateral Interest History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/futures/loan/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.collateralCoin, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<FuturesInterestRecord> getInterestHistory(String collateralCoin, Long startTime, Long endTime, Long current, Long limit);
}