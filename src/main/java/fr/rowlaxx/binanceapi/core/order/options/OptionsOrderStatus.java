package fr.rowlaxx.binanceapi.core.order.options;

import fr.rowlaxx.binanceapi.core.order.OrderStatus;

public enum OptionsOrderStatus implements OrderStatus {

	RECEIVED(0),
	UNTRIGGERED(1),
	ACCEPTED(2),
	REJECTED(3),
	PARTIALLY_FILLED(4),
	FILLED(5),
	CANCELLING(6),
	CANCELLED(7);
	
	private int type;
	
	private OptionsOrderStatus(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.valueOf(type);
	}
	
}
