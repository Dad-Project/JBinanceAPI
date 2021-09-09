package fr.rowlaxx.binanceapi.core.order.spot;

import fr.rowlaxx.binanceapi.core.order.OrderTypes;

public enum SpotOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	STOP_LOSS,
	STOP_LOSS_LIMIT,
	TAKE_PROFIT,
	TAKE_PROFIT_LIMIT,
	LIMIT_MAKER
	
}
