package fr.rowlaxx.binanceapi.core.subaccount;

public enum FuturesType {

	USDM(1),
	COINM(2);
	
	private int type;
	
	private FuturesType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.valueOf(type);
	}
	
}
