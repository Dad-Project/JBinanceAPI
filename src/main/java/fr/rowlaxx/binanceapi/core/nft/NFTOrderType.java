package fr.rowlaxx.binanceapi.core.nft;

public enum NFTOrderType {

	PURCHASE(0),
	SELL(1),
	ROYALTY_INCOME(2),
	PRIMARY_MARKET_ORDER(3),
	MINT_FEE(4);
	
	private final int no;
	
	private NFTOrderType(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return String.valueOf(no);
	}
	
}
