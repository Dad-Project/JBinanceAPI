package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.convertutils.annotations.EnumMatcher;

public enum AccountSnapshotTypes {

	@EnumMatcher(caseSensitiv = false)
	SPOT,
	@EnumMatcher(caseSensitiv = false)
	MARGIN,
	@EnumMatcher(caseSensitiv = false)
	FUTURES
	
}
