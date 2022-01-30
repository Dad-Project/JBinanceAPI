package fr.rowlaxx.binanceapi.core;

import java.util.Map;

public interface OrderBook {

	public Map<Double, Double> getBids();
	
	public Map<Double, Double> getAsks();
	
}
