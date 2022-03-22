package fr.rowlaxx.binanceapi.api.spot;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.DepositAddress;
import fr.rowlaxx.binanceapi.core.wallet.APIKeyPermission;
import fr.rowlaxx.binanceapi.core.wallet.AccountAPITradingStatus;
import fr.rowlaxx.binanceapi.core.wallet.AccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.AccountSnapshotTypes;
import fr.rowlaxx.binanceapi.core.wallet.AssetDetail;
import fr.rowlaxx.binanceapi.core.wallet.AssetDividend;
import fr.rowlaxx.binanceapi.core.wallet.BNBConvertableAsset;
import fr.rowlaxx.binanceapi.core.wallet.CoinInformation;
import fr.rowlaxx.binanceapi.core.wallet.Deposit;
import fr.rowlaxx.binanceapi.core.wallet.DustTransfer;
import fr.rowlaxx.binanceapi.core.wallet.DustTransferRecord;
import fr.rowlaxx.binanceapi.core.wallet.FundingWallet;
import fr.rowlaxx.binanceapi.core.wallet.FuturesAccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.MarginAccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.SpotAccountSnapshot;
import fr.rowlaxx.binanceapi.core.wallet.SystemStatus;
import fr.rowlaxx.binanceapi.core.wallet.TradeFee;
import fr.rowlaxx.binanceapi.core.wallet.Transfer;
import fr.rowlaxx.binanceapi.core.wallet.TransferHistoryRequest;
import fr.rowlaxx.binanceapi.core.wallet.TransferType;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransfer;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferHistoryRequest;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferRequest;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferTypes;
import fr.rowlaxx.binanceapi.core.wallet.Withdraw;
import fr.rowlaxx.binanceapi.core.wallet.WithdrawRequest;
import fr.rowlaxx.convertutils.MapKey;

/**
 * @author RowlaxX
 * @version 2022-03-19
 * @see https://binance-docs.github.io/apidocs/spot/en/#wallet-endpoints
 */
public interface WalletAPI extends Api.Spot, Api.Https {

	//System Status (System)
	@ApiEndpoint (
			endpoint = "/sapi/v1/system/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public SystemStatus getSystemStatus();

	//All Coins' Information (USER_DATA)
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

	default CoinInformation getCoinInformation(String coin) {
		return getAllCoinsInformation().get(coin);
	}
	
	//Daily Account Snapshot (USER_DATA)
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
	public List<SpotAccountSnapshot> getDailySpotAccountSnapshots(Long startTime, Long endTime, Integer limit);

	
	
	default List<SpotAccountSnapshot> getDailySpotAccountSnapshots(Integer limit) {
		return getDailySpotAccountSnapshots(null, null, limit);
	}
	
	default SpotAccountSnapshot getDailySpotAccountSnapshot() {
		return getDailySpotAccountSnapshots(null, null, 1).get(0);
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
	public List<MarginAccountSnapshot> getDailyMarginAccountSnapshots(Long startTime, Long endTime, Integer limit);

	default List<MarginAccountSnapshot> getDailyMarginAccountSnapshots(Integer limit){
		return getDailyMarginAccountSnapshots(null, null, limit);
	}
	
	default MarginAccountSnapshot getDailyMarginAccountSnapshot() {
		return getDailyMarginAccountSnapshots(null, null, 1).get(0);
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
	public List<FuturesAccountSnapshot> getDailyFuturesAccountSnapshots(Long startTime, Long endTime, Integer limit);

	default List<FuturesAccountSnapshot> getDailyFuturesAccountSnapshots(Integer limit){
		return getDailyFuturesAccountSnapshots(null, null, limit);
	}
	
	default FuturesAccountSnapshot getDailyFuturesAccountSnapshot() {
		return getDailyFuturesAccountSnapshots(null, null, 1).get(0);
	}
	
	@SuppressWarnings("unchecked")
	default <T extends AccountSnapshot> List<T> getDailyAccountSnapshots(AccountSnapshotTypes type, Long startTime, Long endTime, Integer limit) {
		if (type == null)
			throw new NullPointerException();
		
		if (type == AccountSnapshotTypes.SPOT)
			return (List<T>) getDailySpotAccountSnapshots(startTime, endTime, limit);
		else if (type == AccountSnapshotTypes.MARGIN)
			return (List<T>) getDailyMarginAccountSnapshots(startTime, endTime, limit);
		else
			return (List<T>) getDailyFuturesAccountSnapshots(startTime, endTime, limit);
	}
	
	default <T extends AccountSnapshot> List<T> getDailyAccountSnapshots(AccountSnapshotTypes type, Integer limit){
		return getDailyAccountSnapshots(type, null, null, limit);
	}
	
	@SuppressWarnings("unchecked")
	default <T extends AccountSnapshot> T getDailyAccountSnapshot(AccountSnapshotTypes type) {
		return (T) getDailyAccountSnapshots(type, null, null, 1).get(0);
	}
	
	//Disable Fast Withdraw Switch (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/account/disableFastWithdrawSwitch",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public void disableFastWithdraw();

	//Enable Fast Withdraw Switch (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/account/enableFastWithdrawSwitch",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public void enableFastWithdraw();

	//Withdraw(USER_DATA)
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

	//Deposit History(supporting network) (USER_DATA)
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
	public List<Deposit> getDepositHistory(TransferHistoryRequest request);
	
	default List<Deposit> getDepositHistory(Integer limit) {
		return getDepositHistory(null, null, null, null, null, limit);
	}
	
	//Withdraw History (supporting network) (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.withdrawOrderId, Parameters.status, Parameters.offset, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {false, false, false, false, false, false, false}
	)
	public List<Withdraw> getWithdrawHistory(String coin, String withdrawOrderId, Integer status, Integer offset, Integer limit, Long startTime, Long endTime);

	default Withdraw getWithdrawRecord(String withdrawOrderId) {
		return getWithdrawHistory(null, withdrawOrderId, null, null, null, null, null).get(0);
	}
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/withdraw/history",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.status, Parameters.offset, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {false, false, false, false, false, false}
	)
	public List<Withdraw> getWithdrawHistory(TransferHistoryRequest request);
	
	default List<Withdraw> getWithdrawHistory(Integer limit){
		return getWithdrawHistory(null, null, null, null, limit, null, null);
	}
	
	@SuppressWarnings("unchecked")
	default <T extends Transfer> List<T> getTransferHistory(TransferType type, TransferHistoryRequest request) {
		if (type == null)
			throw new NullPointerException();
		
		if (type == TransferType.DEPOSIT)
			return (List<T>) getDepositHistory(request);
		else
			return (List<T>) getWithdrawHistory(request);
	}
	
	//Deposit Address (supporting network) (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/capital/deposit/address",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.coin, Parameters.network},
			mandatory = {true, false}
	)
	public DepositAddress getDepositAddress(String coin, String network);

	//Account Status (USER_DATA)
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

	//Account API Trading Status (USER_DATA)
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

	//DustLog(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dribblet",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime},
			mandatory = {false, false}
	)
	@RedirectResponse(path = "userAssetDribblets")
	public List<DustTransferRecord> getDustTransferHistory(Long startTime, Long endTime);

	default List<DustTransferRecord> getDustTransferHistory() {
		return getDustTransferHistory(null, null);
	}
	
	//Dust Transfer (USER_DATA)
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

	//Asset Dividend Record (USER_DATA)
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
	
	//Asset Detail (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/assetDetail",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public Map<String, AssetDetail> getAssetsDetails();
	
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

	//Trade Fee (USER_DATA)
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

	//User Universal Transfer (USER_DATA)
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
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.type, Parameters.asset, Parameters.amount, Parameters.fromSymbol, Parameters.toSymbol},
			mandatory = {true, true, true, false, false}
	)
	@RedirectResponse(path = "tranId")
	public long universalTransfer(UniversalTransferRequest request);

	//Query User Universal Transfer History (USER_DATA)
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
	public List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferHistoryRequest request);
	
	default List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferTypes type, String fromSymbol, String toSymbol) {
		return getUniversalTransferHistory(type, null, null, null, null, fromSymbol, toSymbol);
	}
	
	default List<UniversalTransfer> getUniversalTransferHistory(UniversalTransferTypes type) {
		return getUniversalTransferHistory(type, null, null, null, null, null, null);
	}
	
	//Funding Wallet (USER_DATA)
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
	
	//Get API Key Permission (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/account/apiRestrictions",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public APIKeyPermission getAPIKeyPermission();
	
	//Get Assets That Can Be Converted Into BNB
	@ApiEndpoint (
			endpoint = "/sapi/v1/asset/dust-btc",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "details")
	@MapKey(fieldName = "asset")
	public Map<String, BNBConvertableAsset> getBNBConvertableAssets();
	
}
