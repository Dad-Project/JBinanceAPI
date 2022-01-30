package fr.rowlaxx.binanceapi.core.spot.wallet;

import fr.rowlaxx.convertutils.annotations.EnumMatcher;

public enum AccountSnapshotTypes {

	@EnumMatcher(caseSensitiv = false)
	SPOT,
	@EnumMatcher(caseSensitiv = false)
	MARGIN,
	@EnumMatcher(caseSensitiv = false)
	FUTURES
	
}
