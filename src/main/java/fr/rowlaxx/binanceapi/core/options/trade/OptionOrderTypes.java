package fr.rowlaxx.binanceapi.core.options.trade;

import fr.rowlaxx.binanceapi.core.OrderTypes;

public enum OptionOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	REDUCING,
	REDUCED,
	LIQUIDATION;
	
}
