package fr.rowlaxx.binanceapi.core.market;

public interface Candlestick {

	public long getOpenTime();
	public long getCloseTime();
	public double getOpen();
	public double getClose();
	public double getLow();
	public double getHigh();
	
	default double getChange() {
		return getClose() - getOpen();
	}
	
}
