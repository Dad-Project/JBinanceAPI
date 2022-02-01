package fr.rowlaxx.binanceapi.core.options.trade;

import fr.rowlaxx.binanceapi.core.SimpleOrderStatus;

public enum OptionOrderStatus implements SimpleOrderStatus {

	RECEIVED(0),
	UNTRIGGERED(1),
	ACCEPTED(2),
	REJECTED(3),
	PARTIALLY_FILLED(4),
	FILLED(5),
	CANCELLING(6),
	CANCELLED(7);
	
	private int type;
	
	private OptionOrderStatus(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.valueOf(type);
	}
	
}
