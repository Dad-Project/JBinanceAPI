package fr.rowlaxx.binanceapi.core.margin;

import java.util.Set;

import org.json.JSONObject;

public class CrossFeeData extends Fee {
	private static final long serialVersionUID = -4561320026233915486L;

	private int vipLevel;
	private boolean transferIn;
	private boolean borrowable;
	private double yearlyInterest;
	private Set<String> marginablePairs;
	
	public CrossFeeData(JSONObject json) {
		super(json);
	}
	
	public Set<String> getMarginablePairs() {
		return marginablePairs;
	}
	
	public int getVipLevel() {
		return vipLevel;
	}
	
	public double getYearlyInterest() {
		return yearlyInterest;
	}
	
	public boolean isBorrowable() {
		return borrowable;
	}
	
	public boolean transferIn() {
		return transferIn;
	}
}
