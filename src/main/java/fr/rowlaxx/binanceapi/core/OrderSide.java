package fr.rowlaxx.binanceapi.core;

import fr.rowlaxx.convertutils.annotations.EnumMatcher;

public enum OrderSide {

	@EnumMatcher(possibleMatchs = {"BUY", "1"}, caseSensitiv = false)
	BUY,
	@EnumMatcher(possibleMatchs = {"SELL", "-1"}, caseSensitiv = false)
	SELL
	
}
