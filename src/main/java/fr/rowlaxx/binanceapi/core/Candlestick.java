package fr.rowlaxx.binanceapi.core;

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
	
	default double getChangeUp() {
		return Math.max(0, getChange());
	}
	
	default double getChangeDown() {
		return -Math.min(0, getChange());
	}
	
	default double getAbsChange() {
		return Math.abs(getChange());
	}
	
	default double getHL2() {
		return (getHigh() + getLow()) / 2;
	}
	
	default double getHLC3() {
		return (getHigh() + getLow() + getClose()) / 3;
	}
	
	default double getOHLC4() {
		return (getHigh() + getLow() + getClose() + getOpen()) / 4;
	}
}