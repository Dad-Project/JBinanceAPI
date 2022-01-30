package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.cryptoloans.IncomeRecord;
import fr.rowlaxx.binanceapi.core.cryptoloans.CryptoLoansTypes;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#crypto-loans-endpoints
 */
public interface CryptoLoansAPI extends Api.Https, Api.Spot {

	//Get Crypto Loans Income History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/loan/income",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<IncomeRecord> getIncomeHistory(String asset, CryptoLoansTypes type, Long startTime, Long endTime, Integer limit);
	
	default List<IncomeRecord> getIncomeHistory(String asset, CryptoLoansTypes type, Integer limit){
		return getIncomeHistory(asset, type, null, null, limit);
	}
	
}
