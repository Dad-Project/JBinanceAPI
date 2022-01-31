package fr.rowlaxx.binanceapi.core.futures.marketdata;

import org.json.JSONObject;

public abstract class PositionLongShortRatio extends LongShortRatio {
	private static final long serialVersionUID = 6549125044867626209L;
	
	private double longPosition;
	private double shortPosition;

	public PositionLongShortRatio(JSONObject json) {
		super(json);
	}

	public final double getLongPosition() {
		return longPosition;
	}
	
	public final double getShortPosition() {
		return shortPosition;
	}
}