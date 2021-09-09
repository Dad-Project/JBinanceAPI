package fr.rowlaxx.binanceapi.core.order.future;

import fr.rowlaxx.binanceapi.core.order.OrderTypes;

public enum FutureOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	STOP,
	STOP_MARKET,
	TAKE_PROFIT,
	TAKE_PROFIT_MARKET,
	TRAILING_STOP_MARKET
	
}
