package fr.rowlaxx.binanceapi.core.order.options;

import fr.rowlaxx.binanceapi.core.order.OrderTypes;

public enum OptionsOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	REDUCING,
	REDUCED,
	LIQUIDATION;
	
}
