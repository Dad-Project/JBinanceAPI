package fr.rowlaxx.binanceapi.core.futures.marketdata;

import fr.rowlaxx.convertutils.annotations.EnumMatcher;

public enum UnderlyingSubTypes {

	Storage,
	@EnumMatcher(possibleMatchs = {"DeFi", "DEFI"}) DeFi,
	NFT,
	PoW,
	@EnumMatcher(possibleMatchs = "Layer-1") Layer1,
	@EnumMatcher(possibleMatchs = "Layer-2") Layer2,
	Payment,
	Oracle,
	Privacy,
	CEX,
	DAO,
	DEX,
	Meme,
	Infrastructure,
	Metaverse,
	BUSD,
	Wallet,
	INDEX
	
}
