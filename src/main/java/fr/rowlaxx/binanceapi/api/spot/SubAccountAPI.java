package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.Asset;
import fr.rowlaxx.binanceapi.core.DepositAddress;
import fr.rowlaxx.binanceapi.core.subaccount.AccountTypes;
import fr.rowlaxx.binanceapi.core.subaccount.AssetTransfer;
import fr.rowlaxx.binanceapi.core.subaccount.AssetTransferResult;
import fr.rowlaxx.binanceapi.core.subaccount.FuturesDetail;
import fr.rowlaxx.binanceapi.core.subaccount.FuturesSummary;
import fr.rowlaxx.binanceapi.core.subaccount.FuturesType;
import fr.rowlaxx.binanceapi.core.subaccount.IPRestriction;
import fr.rowlaxx.binanceapi.core.subaccount.ManagedAsset;
import fr.rowlaxx.binanceapi.core.subaccount.MarginDetail;
import fr.rowlaxx.binanceapi.core.subaccount.MarginSummary;
import fr.rowlaxx.binanceapi.core.subaccount.PositionRisk;
import fr.rowlaxx.binanceapi.core.subaccount.SpotAssetsSummary;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccount;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountStatus;
import fr.rowlaxx.binanceapi.core.subaccount.SubAccountTransfer;
import fr.rowlaxx.binanceapi.core.subaccount.SubaccountTransferHistoryRequest;
import fr.rowlaxx.binanceapi.core.subaccount.UniversalTransfer;
import fr.rowlaxx.binanceapi.core.wallet.Deposit;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.utils.IterableArray;

/**
 * @version 2022-01-27
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#sub-account-endpoints
 */
public interface SubAccountAPI extends Api.Https, Api.Spot {

	//Create a Virtual Sub-account(For Master Account)
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

	//Query Sub-account List (For Master Account)
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
	public Map<String, SubAccount> getSubAccounts(String email, Boolean isFreeze, Integer page, Integer limit);

	default Map<String, SubAccount> getSubaccounts(Integer limit){
		return getSubAccounts(null, null, null, limit);
	}
	
	default SubAccount getSubAccount(String email) {
		if (email == null)
			throw new NullPointerException("email may not be null.");
		return getSubAccounts(email, null, null, null).get(email);
	}
	
	//Query Sub-account Spot Asset Transfer History (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/sub/transfer/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<AssetTransfer> getSpotAssetTransferHistory(String fromEmail, String toEmail, Long startTime, Long endTime, Integer page, Integer limit);

	default List<AssetTransfer> getSpotAssetTransferHistory(String fromEmail, String toEmail, Integer page, Integer limit) {
		return getSpotAssetTransferHistory(fromEmail, toEmail, null, null, page, limit);
	}
	
	default List<AssetTransfer> getSpotAssetTransferHistory(Integer limit) {
		return getSpotAssetTransferHistory(null, null, null, null, null, limit);
	}
	
	//Query Sub-account Futures Asset Transfer History (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.futuresType, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.limit},
			mandatory = {true, true, false, false, false, false}
	)
	@RedirectResponse(path = "transfers")
	public List<AssetTransfer> getFuturesAssetTransferHistory(String email, FuturesType futuresType, Long startTime, Long endTime, Integer page, Integer limit);

	default List<AssetTransfer> getFuturesAssetTransferHistory(String fromEmail, FuturesType futuresType, Integer page, Integer limit) {
		return getFuturesAssetTransferHistory(fromEmail, futuresType, null, null, page, limit);
	}
	
	default List<AssetTransfer> getFuturesAssetTransferHistory(Integer limit) {
		return getFuturesAssetTransferHistory(null, null, null, null, null, limit);
	}
	
	//Sub-account Futures Asset Transfer (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/internalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.futuresType, Parameters.asset, Parameters.amount},
			mandatory = {true, true, true, true, true}
	)
	public AssetTransferResult transferFuturesAsset(String fromEmail, String toEmail, FuturesType futuresType, String asset, Double amount);

	//Query Sub-account Assets (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v3/sub-account/assets",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@RedirectResponse(path = "balances")
	public Map<String, Asset> getAssets(String email);

	//Query Sub-account Spot Assets Summary (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/spotSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.page, Parameters.size},
			mandatory = {false, false, false}
	)
	public SpotAssetsSummary getSpotAssetsSummary(String email, Long page, Long size);

	//Get Sub-account Deposit Address (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subAddress",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.network},
			mandatory = {true, true, false}
	)
	public DepositAddress getDepositAddress(String email, String coin, String network);

	//Get Sub-account Deposit History (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subHisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.offset},
			mandatory = {true, false, false, false, false, false, false}
	)
	public List<Deposit> getDepositHistory(String email, String coin, Integer status, Long startTime, Long endTime, Integer limit, Integer offset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/subHisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.offset},
			mandatory = {true, false, false, false, false, false, false}
	)
	public List<Deposit> getDepositHistory(SubaccountTransferHistoryRequest request);

	//Get Sub-account's Status on Margin/Futures (For Master Account)
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

	//Enable Margin for Sub-account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@RedirectResponse(path = "isMarginEnabled")
	public boolean enableMargin(String email);

	//Get Detail on Sub-account's Margin Account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public MarginDetail getMarginDetail(String email);

	//Get Summary of Sub-account's Margin Account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public MarginSummary getMarginSummary();

	//Enable Futures for Sub-account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	@RedirectResponse(path = "isFuturesEnabled")
	public boolean enableFutures(String email);

	//Get Detail on Sub-account's Futures Account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public FuturesDetail getFuturesDetail(String email);

	//Get Summary of Sub-account's Futures Account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/accountSummary",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public FuturesSummary getFuturesSummary();

	//Get Futures Position-Risk of Sub-account (For Master Account)
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

	//Futures Transfer for Sub-account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/futures/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long transferFutures(String email, String asset, double amount, int type);

	//Margin Transfer for Sub-account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long transferMargin(String email, String asset, double amount, int type);

	//Transfer to Sub-account of Same Master (For Sub-account)
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

	//Transfer to Master (For Sub-account)
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

	//Sub-account Transfer History (For Sub-account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/transfer/subUserHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<SubAccountTransfer> getTransferHistory(String asset, Integer type, Long startTime, Long endTime, Integer limit);

	default List<SubAccountTransfer> getTransferHistory(String asset, Integer type, Integer limit){
		return getTransferHistory(asset, type, null, null, limit);
	}
	
	//Universal Transfer (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/universalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.fromAccountType, Parameters.toAccountType, Parameters.clientTranId, Parameters.asset, Parameters.amount},
			mandatory = {false, false, true, true, false, true, true}
	)
	@RedirectResponse(path = "txnId")
	public long universalTransfer(String fromEmail, String toEmail, AccountTypes fromAccountType, AccountTypes toAccountType, String clientTranId, String asset, double amount);

	//Query Universal Transfer History (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/universalTransfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromEmail, Parameters.toEmail, Parameters.startTime, Parameters.endTime, Parameters.clientTranId, Parameters.page, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<UniversalTransfer> getUniversalTransferHistory(String fromEmail, String toEmail, Long startTime, Long endTime, String clientTranId, Integer page, Integer limit);

	default List<UniversalTransfer> getUniversalTransferHistory(String fromEmail, String toEmail, String clientTranId, Integer page, Integer limit){
		return getUniversalTransferHistory(fromEmail, toEmail, null, null, clientTranId, page, limit);
	}
	
	//Get Detail on Sub-account's Futures Account V2 (For Master Account)
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
	public FuturesDetail getFuturesUsdtDetailV2(String email);

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
	public FuturesDetail getFuturesCoinDetailV2(String email);

	default FuturesDetail getFuturesDetailV2(String email, int futuresType) {
		if (futuresType == 1)
			return getFuturesUsdtDetailV2(email);
		else if (futuresType == 2)
			return getFuturesCoinDetailV2(email);
		throw new IllegalArgumentException("futuresType must be 1 or 2.");
	}
	
	//Get Summary of Sub-account's Futures Account V2 (For Master Account)
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
	public FuturesSummary getFuturesUsdtSummaryV2(Integer page, Integer limit);

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
	public FuturesSummary getFuturesCoinSummaryV2(Integer page, Integer limit);

	default FuturesSummary getFuturesSummaryV2(Integer futuresType, Integer page, Integer limit) {
		if (futuresType == 1)
			return getFuturesUsdtSummaryV2(page, limit);
		else if (futuresType == 2)
			return getFuturesCoinSummaryV2(page, limit);
		throw new IllegalArgumentException("futuresType must be 1 or 2.");
	}
	
	//Get Futures Position-Risk of Sub-account V2 (For Master Account)
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
	public List<PositionRisk> getFuturesUsdtPositionRisksV2(String email);

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
	public List<PositionRisk> getFuturesCoinPositionRisksV2(String email);

	default List<PositionRisk> getFuturesPositionRisksV2(Integer futuresType, String email) {
		if (futuresType == 1)
			return getFuturesUsdtPositionRisksV2(email);
		else if (futuresType == 2)
			return getFuturesCoinPositionRisksV2(email);
		throw new IllegalArgumentException("futuresType must be 1 or 2.");
	}
	
	//Enable Leverage Token for Sub-account (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/blvt/enable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.enableBlvt},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "enableBlvt")
	public boolean setLeverageTokenEnabled(String email, boolean enableBlvt);

	//Enable or Disable IP Restriction for a Sub-account API Key (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/subAccountApi/ipRestriction",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.subAccountApiKey, Parameters.ipRestrict},
			mandatory = {true, true, true}
	)
	public IPRestriction setIpRestrictionEnabled(String email, String apiKey, Boolean ipRestrict);

	//Add IP List for a Sub-account API Key (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/subAccountApi/ipRestriction/ipList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.email, Parameters.subAccountApiKey, Parameters.ipAddress},
			mandatory = {true, true, true}
	)
	public IPRestriction addIpToRestriction(String email, String apiKey, String ip);

	default IPRestriction addIpToRestriction(String email, String apiKey, String[] ips) {
		return addIpsToRestriction(email, apiKey, new IterableArray<String>(ips));
	}
	
	default IPRestriction addIpsToRestriction(String email, String apiKey, Iterable<String> ips) {
		if (ips == null)
			throw new NullPointerException("ips may not be null.");
		
		final StringBuilder sb = new StringBuilder();
		for (String ip : ips)
			sb.append(ip).append(',');
		
		if (sb.length() == 0)
			throw new IllegalArgumentException("ips must contains at least one element.");
		
		return addIpToRestriction(email, apiKey, sb.toString());
	}
	
	//Get IP Restriction for a Sub-account API Key (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/subAccountApi/ipRestriction",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email, Parameters.subAccountApiKey},
			mandatory = {true, true}
	)
	public IPRestriction getIpRestriction(String email, String apiKey);

	//Delete IP List for a Sub-account API Key (For Master Account)
	@ApiEndpoint (
			endpoint = "/sapi/v1/sub-account/subAccountApi/ipRestriction/ipList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.email, Parameters.subAccountApiKey, Parameters.ipAddress},
			mandatory = {true, true, true}
	)
	public IPRestriction deleteIpFromRestriction(String email, String apiKey, String ip);

	default IPRestriction deleteIpsFromRestriction(String email, String apiKey, String[] ips) {
		return deleteIpsFromRestriction(email, apiKey, new IterableArray<String>(ips));
	}
	
	default IPRestriction deleteIpsFromRestriction(String email, String apiKey, Iterable<String> ips) {
		if (ips == null)
			throw new NullPointerException("ips may not be null.");
		
		final StringBuilder sb = new StringBuilder();
		for (String ip : ips)
			sb.append(ip).append(',');
		
		if (sb.length() == 0)
			throw new IllegalArgumentException("ips must contains at least one element.");
		
		return deleteIpFromRestriction(email, apiKey, sb.toString());
	}
	
	//Deposit assets into the managed sub-account（For Investor Master Account）
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

	//Query managed sub-account asset details（For Investor Master Account）
	@ApiEndpoint (
			endpoint = "/sapi/v1/managed-subaccount/asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.email},
			mandatory = {true}
	)
	public List<ManagedAsset> getManagedAssetDetails(String email);

	//Withdrawl assets from the managed sub-account（For Investor Master Account）
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