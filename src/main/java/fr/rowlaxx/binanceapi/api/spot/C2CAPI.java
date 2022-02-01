package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.c2c.C2CTradeRecord;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#c2c-endpoints
 */
public interface C2CAPI extends Api.Https, Api.Spot {

	//Get C2C Trade History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/c2c/orderMatch/listUserOrderHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tradeType, Parameters.startTimestamp, Parameters.endTimestamp, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<C2CTradeRecord> getC2CTradeHistory(OrderSides tradeType, Long startTimestamp, Long endTimestamp, Integer page, Integer rows);

	default List<C2CTradeRecord> getCC2CTradeHistory(OrderSides tradeType, Integer page, Integer rows){
		return getC2CTradeHistory(tradeType, null, null, page, rows);
	}
	
	default List<C2CTradeRecord> getCC2CBuyHistory(Long start, Long end, Integer page, Integer rows){
		return getC2CTradeHistory(OrderSides.BUY, start, end, page, rows);
	}
	
	default List<C2CTradeRecord> getCC2CBuyHistory(Integer page, Integer rows){
		return getC2CTradeHistory(OrderSides.BUY, null, null, page, rows);
	}
	
	default List<C2CTradeRecord> getCC2CSellHistory(Long start, Long end, Integer page, Integer rows){
		return getC2CTradeHistory(OrderSides.SELL, start, end, page, rows);
	}
	
	default List<C2CTradeRecord> getCC2CSellHistory(Integer page, Integer rows){
		return getC2CTradeHistory(OrderSides.SELL, null, null, page, rows);
	}
}