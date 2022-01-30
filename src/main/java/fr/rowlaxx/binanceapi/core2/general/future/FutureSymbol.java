package fr.rowlaxx.binanceapi.core2.general.future;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.TimeInForce;
import fr.rowlaxx.binanceapi.core.exchangeinfos.Symbol;
import fr.rowlaxx.binanceapi.core2.order.future.FutureOrderTypes;
import fr.rowlaxx.jsavon.annotations.JOValue;

public abstract class FutureSymbol extends Symbol<FutureOrderTypes> {
	private static final long serialVersionUID = 4784472032259702080L;

	//Variables
	private int quantityPrecision;
	private int pricePrecision;
	private double requiredMarginPercent;
	private long onboardDate;
	private String pair;
	private double triggerProtect;
	private String marginAsset;
	private double liquidationFee;
	private double maintMarginPercent;
	private double marketTakeBound;
	private long deliveryDate;
	private FutureContractTypes contractType;
	private UnderlyingTypes underlyingType;
	private Set<UnderlyingSubTypes> underlyingSubType;
	private Set<TimeInForce> timeInForce;
	@JOValue(key = {"status", "contractStatus"})
	private FutureContractStatus status;
	
	//Constructeurs
	public FutureSymbol(JSONObject response) {
		super(response);
	}
	
	//Getter
	public FutureContractTypes getContractType() {
		return contractType;
	}
	
	public long getDeliveryDate() {
		return deliveryDate;
	}
	
	public double getLiquidationFee() {
		return liquidationFee;
	}
	
	public double getMaintMarginPercent() {
		return maintMarginPercent;
	}
	
	public String getMarginAsset() {
		return marginAsset;
	}
	
	public double getMarketTakeBound() {
		return marketTakeBound;
	}
	
	public long getOnboardDate() {
		return onboardDate;
	}
	
	public String getPair() {
		return pair;
	}
	
	public int getPricePrecision() {
		return pricePrecision;
	}
	
	public int getQuantityPrecision() {
		return quantityPrecision;
	}
	
	public double getRequiredMarginPercent() {
		return requiredMarginPercent;
	}
	
	public FutureContractStatus getStatus() {
		return status;
	}
	
	public Set<TimeInForce> getTimeInForces() {
		return timeInForce;
	}
	
	public boolean hasTimeInForce(TimeInForce tif) {
		return timeInForce.contains(tif);
	}
	
	public double getTriggerProtect() {
		return triggerProtect;
	}
	
	public Set<UnderlyingSubTypes> getUnderlyingSubTypes() {
		return underlyingSubType;
	}
	
	public boolean hasUnderlyingSubType(UnderlyingSubTypes underlyingSubType) {
		return this.underlyingSubType.contains(underlyingSubType);
	}
	
	public UnderlyingTypes getUnderlyingType() {
		return underlyingType;
	}
}
