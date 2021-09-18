package fr.rowlaxx.binanceapi.core.order;

public enum BasicOrderStatus implements OrderStatus {
	
	NEW,
	PARTIALLY_FILLED,
	FILLED,
	CANCELED,
	PENDING_CANCEL,
	REJECTED,
	EXPIRED
	
}
