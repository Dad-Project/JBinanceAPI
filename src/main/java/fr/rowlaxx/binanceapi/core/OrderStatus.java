package fr.rowlaxx.binanceapi.core;

public enum OrderStatus implements SimpleOrderStatus {
	
	NEW,
	PARTIALLY_FILLED,
	FILLED,
	CANCELED,
	PENDING_CANCEL,
	REJECTED,
	EXPIRED
	
}
