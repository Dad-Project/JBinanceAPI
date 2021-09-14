package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.annotations.EnumMatcher;

public enum DailyAccountSnapshotTypes {

	@EnumMatcher(caseSensitiv = false)
	SPOT,
	@EnumMatcher(caseSensitiv = false)
	MARGIN,
	@EnumMatcher(caseSensitiv = false)
	FUTURES
	
}
