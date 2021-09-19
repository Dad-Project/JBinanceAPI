package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.general.SystemStatus;
import fr.rowlaxx.binanceapi.core.wallet.APIKeyPermission;
import fr.rowlaxx.binanceapi.core.wallet.AccountAPITradingStatus;
import fr.rowlaxx.binanceapi.core.wallet.AssetDetail;
import fr.rowlaxx.binanceapi.core.wallet.AssetDividend;
import fr.rowlaxx.binanceapi.core.wallet.CoinInformation;
import fr.rowlaxx.binanceapi.core.wallet.Deposit;
import fr.rowlaxx.binanceapi.core.wallet.DepositAddress;
import fr.rowlaxx.binanceapi.core.wallet.DepositHistoryRequest;
import fr.rowlaxx.binanceapi.core.wallet.DustTransfer;
import fr.rowlaxx.binanceapi.core.wallet.FundingWallet;
import fr.rowlaxx.binanceapi.core.wallet.PastDustTransfer;
import fr.rowlaxx.binanceapi.core.wallet.TradeFee;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransfer;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferRequest;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferTypes;
import fr.rowlaxx.binanceapi.core.wallet.Withdraw;
import fr.rowlaxx.binanceapi.core.wallet.WithdrawHistoryRequest;
import fr.rowlaxx.binanceapi.core.wallet.WithdrawRequest;
import fr.rowlaxx.binanceapi.core.wallet.future.FutureDailyAccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.margin.MarginDailyAccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.spot.SpotDailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface SpotWalletAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/system/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public SystemStatus getSystemStatus();

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/config/getall",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "coin")
	public Map<String, CoinInformation> getAllCoinsInformation();

	
	@ApiEndpoint (
			endpoint = "/sapi/v1/accountSnapshot",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false},
			defaultValues = {"SPOT", "", "", ""}
	)
	@RedirectResponse(path = "snapshotVos")
	public List<SpotDailyAccountSnapshot> getSpotDailyAccountSnapshots(Long startTime, Long endTime, Integer limit);

	default List<SpotDailyAccountSnapshot> getSpotDailyAccountSnapshots(Integer limit) {
		return getSpotDailyAccountSnapshots(null, null, limit);
	}
	
	default SpotDailyAccountSnapshot getSpotDailyAccountSnapshot() {
		return getSpotDailyAccountSnapshots(1).get(0);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/accountSnapshot",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false},
			defaultValues = {"MARGIN", "", "", ""}
	)
	@RedirectResponse(path = "snapshotVos")
	public List<MarginDailyAccountSnapshot> getMarginDailyAccountSnapshots(Long startTime, Long endTime, Integer limit);

	default List<MarginDailyAccountSnapshot> getMarginDailyAccountSnapshots(Integer limit){
		return getMarginDailyAccountSnapshots(null, null, limit);
	}
	
	default MarginDailyAccountSnapshot getMarginDailyAccountSnapshot() {
		return getMarginDailyAccountSnapshots(1).get(0);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/accountSnapshot",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false},
			defaultValues = {"FUTURES", "", "", ""}
	)
	@RedirectResponse(path = "snapshotVos")
	public List<FutureDailyAccountSnapshot> getFutureDailyAccountSnapshots(Long startTime, Long endTime, Integer limit);

	default List<FutureDailyAccountSnapshot> getFutureDailyAccountSnapshots(Integer limit){
		return getFutureDailyAccountSnapshots(null, null, limit);
	}
	
	default FutureDailyAccountSnapshot getFutureDailyAccountSnapshot() {
		return getFutureDailyAccountSnapshots(1).get(0);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/account/disableFastWithdrawSwitch",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public void disableFastWithdrawSwitch();

	@ApiEndpoint (
			endpoint = "/sapi/v1/account/enableFastWithdrawSwitch",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public void enableFastWithdrawSwitch();

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/apply",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.network, Parameters.address, Parameters.addressTag, Parameters.amount, Parameters.transactionFeeFlag, Parameters.name},
			mandatory = {true, false, false, true, false, true, false, false}
	)
	@RedirectResponse(path = "id")
	public long withdraw(String coin, String withdrawOrderId, String network, String address, String addressTag, double amount, Boolean transactionFeeFlag, String name);

	default long withdraw(String coin, String address, String addressTag, double amount) {
		final WithdrawRequest request = new WithdrawRequest();
		request.coin = coin;
		request.address = address;
		request.addressTag = addressTag;
		request.amount = amount;
		return withdraw(request);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/apply",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.network, Parameters.address, Parameters.addressTag, Parameters.amount, Parameters.transactionFeeFlag, Parameters.name},
			mandatory = {true, false, false, true, false, true, false, false}
	)
	@RedirectResponse(path = "id")
	public long withdraw(WithdrawRequest request);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/hisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.offset, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<Deposit> getDepositHistory(String coin, Integer status, Long startTime, Long endTime, Integer offset, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/hisrec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.status, Parameters.startTime, Parameters.endTime, Parameters.offset, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<Deposit> getDepositHistory(DepositHistoryRequest request);
	
	default List<Deposit> getDepositHistory(Integer limit) {
		return getDepositHistory(null, null, null, null, null, limit);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.status, Parameters.offset, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {false, false, false, false, false, false, false}
	)
	public List<Withdraw> getWithdrawHistory(String coin, String withdrawOrderId, Integer status, Integer offset, Integer limit, Long startTime, Long endTime);

	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.status, Parameters.offset, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {false, false, false, false, false, false, false}
	)
	public List<Withdraw> getWithdrawHistory(WithdrawHistoryRequest request);
	
	default List<Withdraw> getWithdrawHistory(Integer limit){
		return getWithdrawHistory(null, null, null, null, limit, null, null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/address",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.network},
			mandatory = {true, false}
	)
	public DepositAddress getDepositAddress(String coin, String network);

	@ApiEndpoint (
			endpoint = "/sapi/v1/account/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	public String getAccountStatus();

	@ApiEndpoint (
			endpoint = "/sapi/v1/account/apiTradingStatus",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	public AccountAPITradingStatus getAccountAPITradingStatus();

	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dribblet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime},
			mandatory = {false, false}
	)
	@RedirectResponse(path = "userAssetDribblets")
	public List<PastDustTransfer> getDustTransferHistory(Long startTime, Long endTime);

	default List<PastDustTransfer> getDustTransferHistory() {
		return getDustTransferHistory(null, null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dust",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public DustTransfer dustTransfer(String asset);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dust",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public DustTransfer dustTransfer(String... asset);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dust",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public DustTransfer dustTransfer(Collection<String> asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/assetDividend",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<AssetDividend> getAssetDividendRecords(String asset, Long startTime, Long endTime, Integer limit);

	default List<AssetDividend> getAssetDividendRecords(String asset, Integer limit){
		return getAssetDividendRecords(asset, null, null, limit);
	}
	
	default List<AssetDividend> getAssetDividendRecords(Integer limit){
		return getAssetDividendRecords(null, null, null, limit);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/assetDetail",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public Map<String, AssetDetail> getAssetDetails();
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/assetDetail",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	@RedirectResponse(path = "%PARAMETER_NO=0%")
	public AssetDetail getAssetDetails(String asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/tradeFee",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, TradeFee> getTradeFees();
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/tradeFee",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public TradeFee getTradeFee(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.type, Parameters.asset, Parameters.amount, Parameters.fromSymbol, Parameters.toSymbol},
			mandatory = {true, true, true, false, false}
	)
	@RedirectResponse(path = "tranId")
	public long universalTransfer(UniversalTransferTypes type, String asset, double amount, String fromSymbol, String toSymbol);

	default long universalTransfer(UniversalTransferTypes type, String asset, double amount) {
		return universalTransfer(type, asset, amount, null, null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.fromSymbol, Parameters.toSymbol},
			mandatory = {true, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferTypes type, Long startTime, Long endTime, Integer current, Integer size, String fromSymbol, String toSymbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.fromSymbol, Parameters.toSymbol},
			mandatory = {true, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferRequest request);
	
	default List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferTypes type, String fromSymbol, String toSymbol) {
		return getUniversalTransferHistory(type, null, null, null, null, fromSymbol, toSymbol);
	}
	
	default List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferTypes type) {
		return getUniversalTransferHistory(type, null, null, null, null, null, null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/get-funding-asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.needBtcValuation},
			mandatory = {false}
	)
	@MapKey(fieldName = "asset")
	public Map<String, FundingWallet> getFundingWallets(Boolean needBtcValuation);

	default Map<String, FundingWallet> getFundingWallets(){
		return getFundingWallets(null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/get-funding-asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.needBtcValuation},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public FundingWallet getFundingWallet(String asset, Boolean needBtcValuation);
	
	default FundingWallet getFundingWallet(String asset) {
		return getFundingWallet(asset, null);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/account/apiRestrictions",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public APIKeyPermission getGetAPIKeyPermission();
}