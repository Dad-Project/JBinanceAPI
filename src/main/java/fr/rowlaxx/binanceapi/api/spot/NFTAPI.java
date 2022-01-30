package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.nft.NFT;
import fr.rowlaxx.binanceapi.core.nft.NFTOrderType;
import fr.rowlaxx.binanceapi.core.nft.NFTTransactionRecord;
import fr.rowlaxx.binanceapi.core.nft.NFTTransferRecord;
import fr.rowlaxx.binanceapi.core.nft.NFTWithdrawRecord;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints
 */
public interface NFTAPI extends Api.Spot, Api.Https {

	//Get NFT Transaction History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/nft/history/transactions",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.orderType, Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.page},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "list")
	public List<NFTTransactionRecord> getTransactionHistory(NFTOrderType orderType, Long startTime, Long endTime, Integer limit, Integer page);

	default List<NFTTransactionRecord> getTransactionHistory(NFTOrderType orderType, Integer limit, Integer page){
		return getTransactionHistory(orderType, null, null, limit, page);
	}
	
	//Get NFT Deposit History(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/nft/history/deposit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.page},
			mandatory = {false, false, false, false}
	)
	@RedirectResponse(path = "list")
	public List<NFTTransferRecord> getDepositHistory(Long startTime, Long endTime, Integer limit, Integer page);
	
	default List<NFTTransferRecord> getDepositHistory(Integer limit, Integer page){
		return getDepositHistory(null, null, limit, page);
	}
	
	//Get NFT Withdraw History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/nft/history/withdraw",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.limit, Parameters.page},
			mandatory = {false, false, false, false}
	)
	@RedirectResponse(path = "list")
	public List<NFTWithdrawRecord> getWithdrawHistory(Long startTime, Long endTime, Integer limit, Integer page);
	
	default List<NFTWithdrawRecord> getWithdrawHistory(Integer limit, Integer page){
		return getWithdrawHistory(null, null, limit, page);
	}
	
	//Get NFT Asset (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/nft/user/getAsset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.limit, Parameters.page},
			mandatory = {false, false}
	)
	@RedirectResponse(path = "list")
	public List<NFT> getAssets(Integer limit, Integer page);
}
