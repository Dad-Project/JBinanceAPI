package fr.rowlaxx.binanceapi.core.savings;

public enum LiquidityOperationStatus {

	PENDING_FOR_SWAP(0),
	SUCCESS(1),
	FAILED(2);
	
	private int no;
	
	private LiquidityOperationStatus(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return String.valueOf(no);
	}
	
}
