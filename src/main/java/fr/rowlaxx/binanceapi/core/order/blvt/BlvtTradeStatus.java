package fr.rowlaxx.binanceapi.core.order.blvt;

import fr.rowlaxx.convertutils.annotations.EnumMatcher;

public enum BlvtTradeStatus {

	@EnumMatcher(possibleMatchs = "S")
	SUCCESS,
	@EnumMatcher(possibleMatchs = "P")
	PENDING,
	@EnumMatcher(possibleMatchs = "F")
	FAILED
	
}
