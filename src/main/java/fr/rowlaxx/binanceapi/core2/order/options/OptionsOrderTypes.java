package fr.rowlaxx.binanceapi.core2.order.options;

import fr.rowlaxx.binanceapi.core.OrderTypes;

public enum OptionsOrderTypes implements OrderTypes {

	LIMIT,
	MARKET,
	REDUCING,
	REDUCED,
	LIQUIDATION;
	
}
