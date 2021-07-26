package fr.rowlaxx.binanceapi.enums.bswap;

public enum LiquidityOperationStatus {

	//Enum
	PENDING(0),
	SUCCESS(1),
	FAILED(2);
	
	//Variables
	private final int code;
	
	//Constructeurs
	private LiquidityOperationStatus(int code) {
		this.code = code;
	}
	
	//Methode
	@Override
	public String toString() {
		return String.valueOf(code);
	}
}
