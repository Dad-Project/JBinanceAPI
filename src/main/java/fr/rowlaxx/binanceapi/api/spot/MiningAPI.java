package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.mining.AccountEarning;
import fr.rowlaxx.binanceapi.core.mining.AccountProfit;
import fr.rowlaxx.binanceapi.core.mining.Algorithm;
import fr.rowlaxx.binanceapi.core.mining.CoinName;
import fr.rowlaxx.binanceapi.core.mining.ConfigDetail;
import fr.rowlaxx.binanceapi.core.mining.MinerDetail;
import fr.rowlaxx.binanceapi.core.mining.MiningStatistics;
import fr.rowlaxx.binanceapi.core.mining.Profit;
import fr.rowlaxx.binanceapi.core.mining.ProfitTransferDetail;
import fr.rowlaxx.binanceapi.core.mining.UserStatistics;
import fr.rowlaxx.binanceapi.core.mining.WorkerData;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints
 */
public interface MiningAPI extends Api.Https, Api.Spot {

	//Acquiring Algorithm (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/pub/algoList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "algoName")
	public Map<String, Algorithm> getAlgorithms();

	//Acquiring CoinName (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/pub/coinList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "coinName")
	public Map<String, CoinName> getCoinNames();

	//Request for Detail Miner List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/worker/detail",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName, Parameters.workerName},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "data")
	public List<MinerDetail> getMinerDetails(String algo, String userName, String workerName);

	//Request for Miner List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/worker/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName, Parameters.pageIndex, Parameters.sort, Parameters.sortColumn, Parameters.workerStatus},
			mandatory = {true, true, false, false, false, false}
	)
	@RedirectResponse(path = "data/workerDatas")
	public List<WorkerData> getMiners(String algo, String userName, Integer pageIndex, Integer sort, Integer sortColumn, Integer workerStatus);

	//Earnings List(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/payment/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName, Parameters.coin, Parameters.startDate, Parameters.endDate, Parameters.pageIndex, Parameters.pageSize},
			mandatory = {true, true, false, false, false, false, false}
	)
	@RedirectResponse(path = "data/accountProfits")
	public List<AccountProfit> getEarnings(String algo, String userName, String coin, Long startDate, Long endDate, Integer pageIndex, Integer pageSize);

	//Extra Bonus List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/payment/other",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName, Parameters.coin, Parameters.startDate, Parameters.endDate, Parameters.pageIndex, Parameters.pageSize},
			mandatory = {true, true, false, false, false, false, false}
	)
	@RedirectResponse(path = "data/otherProfits")
	public List<Profit> getExtraEarnings(String algo, String userName, String coin, Long startDate, Long endDate, Integer pageIndex, Integer pageSize);

	//Hashrate Resale List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/hash-transfer/config/details/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.pageIndex, Parameters.pageSize},
			mandatory = {false, false}
	)
	@RedirectResponse(path = "data/configDetails")
	public List<ConfigDetail> getConfigDetails(Integer pageIndex, Integer pageSize);

	//Hashrate Resale Detail (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/hash-transfer/profit/details",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.configId, Parameters.userName, Parameters.pageIndex, Parameters.pageSize},
			mandatory = {true, true, false, false}
	)
	@RedirectResponse(path = "data/profitTransferDetails")
	public List<ProfitTransferDetail> getProfitTransfers(Integer configId, String userName, Integer pageIndex, Integer pageSize);

	//Hashrate Resale Request (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/hash-transfer/config",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.userName, Parameters.algo, Parameters.endDate, Parameters.startDate, Parameters.toPoolUser, Parameters.hashRate},
			mandatory = {true, true, true, true, true, true}
	)
	@RedirectResponse(path = "data")
	public long requestHashrateResale(String userName, String algo, Long endDate, Long startDate, String toPoolUser, Long hashRate);

	//Cancel hashrate resale configuration(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/hash-transfer/config/cancel",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.configId, Parameters.userName},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data")
	public boolean cancelHashrateResale(Integer configId, String userName);

	//Statistic List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/statistics/user/status",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data")
	public MiningStatistics getStatistics(String algo, String userName);

	//Account List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/statistics/user/list",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.userName},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data")
	public List<UserStatistics> getAccounts(String algo, String userName);
	
	//Mining Account Earning (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/mining/payment/uid",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.algo, Parameters.startDate, Parameters.endDate, Parameters.pageIndex, Parameters.pageSize},
			mandatory = {true, false, false, false, false}
	)
	@RedirectResponse(path = "data/accountProfits")
	public List<AccountEarning> getAccountEarnings(String algo, Long startDate, Long endDate, Integer pageIndex, Integer pageSize);
}