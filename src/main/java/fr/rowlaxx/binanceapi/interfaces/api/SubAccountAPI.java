package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.subaccount.CoinMPositionRisk;
import fr.rowlaxx.binanceapi.core.subaccount.ManagedSubAccountAsset;
import fr.rowlaxx.binanceapi.core.subaccount.PositionRisk;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccount;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountFuturesCoinMDetail;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountFuturesDetail;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountFuturesStatus;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountLeverageTokenStatus;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountMarginDetail;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountMarginStatus;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountSpotSummary;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountStatus;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountsFutureCoinMSummary;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountsFuturesSummary;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountsMarginSummary;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.FutureAssetTransfer;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.FuturesAssetTransferResult;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.FuturesType;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.SpotAssetTransfer;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.SubAccountDepositHistoryRequest;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.SubAccountTransfer;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.UniversalTransfer;
import fr.rowlaxx.binanceapi.core.wallet.Balance;
import fr.rowlaxx.binanceapi.core.wallet.Deposit;
import fr.rowlaxx.binanceapi.core.wallet.DepositAddress;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface SubAccountAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/virtualSubAccount",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.subAccountString},
			mandatory = {true}
	)
	@RedirectResponse(path = "email")
	public String createVirtualSubAccount(String subAccountString);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.isFreeze, Parameters.page, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	@RedirectResponse(path = "subAccounts")
	@MapKey(fieldName = "email")
	public Map<String, SubAccount> querySubaccountList(String email, Boolean isFreeze, int page, int limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/sub/transfer/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<SpotAssetTransfer> querySubAccountSpotAssetTransferHistory(String fromEmail, String toEmail, Long startTime, Long endTime, Integer page, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
			mandatory = {true, true, false, false, false, false}
	)
	@RedirectResponse(path = "transfers")
	public List<FutureAssetTransfer> querySubAccountFuturesAssetTransferHistory(String email, FuturesType futuresType, Long startTime, Long endTime, Integer page, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.futuresType, Parameters.asset, Parameters.amount},
			mandatory = {true, true, true, true, true}
	)
	public FuturesAssetTransferResult subAccountFuturesAssetTransfer(String fromEmail, String toEmail, FuturesType futuresType, String asset, Double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v3/sub-account/assets",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@RedirectResponse(path = "balances")
	public Map<String, Balance> querySubAccountAssets(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/spotSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.page, Parameters.size},
			mandatory = {false, false, false}
	)
	public SubAccountSpotSummary getSubAccountSpotAssetsSummary(String email, Long page, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subAddress",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.network},
			mandatory = {true, true, false}
	)
	public DepositAddress getGetSubAccountDepositAddress(String email, String coin, String network);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subHisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.offset},
			mandatory = {true, false, false, false, false, false, false}
	)
	public List<Deposit> getGetSubaccountDepositHistory(String email, String coin, Integer status, Long startTime, Long endTime, Integer limit, Integer offset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subHisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.offset},
			mandatory = {true, false, false, false, false, false, false}
	)
	public List<Deposit> getGetSubaccountDepositHistory(SubAccountDepositHistoryRequest request);

	
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "email")
	public Map<String, SubAccountStatus> getSubAccountStatus();
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public SubAccountStatus getSubAccountStatus(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public SubAccountMarginStatus enableMargin(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public SubAccountMarginDetail getSubAccountMarginDetail(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public SubAccountsMarginSummary getSubAccountsMarginSummary();

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public SubAccountFuturesStatus enableFutures(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public SubAccountFuturesDetail getSubAccountFuturesDetail(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public SubAccountsFuturesSummary getSubAccountsFuturesSummary();

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/positionRisk",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	public List<PositionRisk> getFuturesPositionRisks(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long futuresTransfer(String email, String asset, double amount, int type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long marginTransfer(String email, String asset, double amount, int type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/transfer/subToSub",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.toEmail, Parameters.asset, Parameters.amount},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long transfer(String toEmail, String asset, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/transfer/subToMaster",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "txnId")
	public long transferToMaster(String asset, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/transfer/subUserHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<SubAccountTransfer> getSubAccountTransferHistory(String asset, Integer type, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/universalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.fromAccountType, Parameters.toAccountType, Parameters.asset, Parameters.amount},
			mandatory = {false, false, true, true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long universalTransfer(String fromEmail, String toEmail, String fromAccountType, String toAccountType, String asset, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/universalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<UniversalTransfer> getUniversalTransferHistory(String fromEmail, String toEmail, Long startTime, Long endTime, Integer page, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType},
			mandatory = {true, true},
			defaultValues = {"", "1"}
	)
	@RedirectResponse(path = "futureAccountResp")
	public SubAccountFuturesDetail getSubAccountFuturesDetailV2(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType},
			mandatory = {true, true},
			defaultValues = {"", "2"}
	)
	@RedirectResponse(path = "deliveryAccountResp")
	public SubAccountFuturesCoinMDetail getSubAccountFuturesCoinMDetailV2(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.futuresType, Parameters.page, Parameters.limit},
			mandatory = {true, false, false},
			defaultValues = {"1", "", ""}
	)
	@RedirectResponse(path = "futureAccountSummaryResp")
	public SubAccountsFuturesSummary getSubAccountsFuturesSummaryV2(Integer page, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.futuresType, Parameters.page, Parameters.limit},
			mandatory = {true, false, false},
			defaultValues = {"2", "", ""}
	)
	@RedirectResponse(path = "deliveryAccountSummaryResp")
	public SubAccountsFutureCoinMSummary getSubAccountsFuturesCoinMSummaryV2(Integer page, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/positionRisk",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType},
			mandatory = {true, true},
			defaultValues = {"", "1"}
	)
	@RedirectResponse(path = "futurePositionRiskVos")
	public List<PositionRisk> getFuturesPositionRisksV2(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v2/sub-account/futures/positionRisk",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType},
			mandatory = {true, true},
			defaultValues = {"", "2"}
	)
	@RedirectResponse(path = "deliveryPositionRiskVos")
	public List<CoinMPositionRisk> getFuturesCoinMPositionRisksV2(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/blvt/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.enableBlvt},
			mandatory = {true, true}
	)
	public SubAccountLeverageTokenStatus enableLeverageToken(String email, boolean enableBlvt);

	@ApiEndpoint (
			endpoint = "/sapi/v1/managed-subaccount/deposit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.toEmail, Parameters.asset, Parameters.amount},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long depositAssetsIntoManager(String toEmail, String asset, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/managed-subaccount/asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public List<ManagedSubAccountAsset> queryManagedSubAccountAssetDetails(String email);

	@ApiEndpoint (
			endpoint = "/sapi/v1/managed-subaccount/withdraw",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.asset, Parameters.amount, Parameters.transferDate},
			mandatory = {true, true, true, false}
	)
	@RedirectResponse(path = "tranId")
	public long withdrawAssetsFromManager(String fromEmail, String asset, double amount, Long transferDate);
}