package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.binanceapi.core.OrderTypes;

public enum FutureOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	STOP,
	STOP_MARKET,
	TAKE_PROFIT,
	TAKE_PROFIT_MARKET,
	TRAILING_STOP_MARKET
	
}
