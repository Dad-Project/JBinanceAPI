package fr.rowlaxx.binanceapi.core.future;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.Symbol;
import fr.rowlaxx.binanceapi.core.trade.TimeInForce;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class FutureSymbol extends Symbol<FutureOrderTypes> {
	private static final long serialVersionUID = -1913309959483097265L;

	//Variables
	@JsonValue private int quantityPrecision;
	@JsonValue private int pricePrecision;
	@JsonValue private double requiredMarginPercent;
	@JsonValue private ContractTypes contractType;
	@JsonValue private long onboardDate;
	@JsonValue private String pair;
	@JsonValue private double triggerProtect;
	@JsonValue private String marginAsset;
	@JsonValue private UnderlyingTypes underlyingType;
	@JsonValue private Set<UnderlyingSubTypes> underlyingSubType;
	@JsonValue private double liquidationFee;
	@JsonValue private double maintMarginPercent;
	@JsonValue private double marketTakeBound;
	@JsonValue private long deliveryDate;
	@JsonValue private Set<TimeInForce> timeInForce;
	
	//Constructeurs
	public FutureSymbol(JSONObject response) {
		super(response);
	}
	
	//Getters

	public int getQuantityPrecision() {
		return quantityPrecision;
	}

	public int getPricePrecision() {
		return pricePrecision;
	}

	public double getRequiredMarginPercent() {
		return requiredMarginPercent;
	}

	public ContractTypes getContractType() {
		return contractType;
	}

	public long getOnboardDate() {
		return onboardDate;
	}

	public String getPair() {
		return pair;
	}

	public double getTriggerProtect() {
		return triggerProtect;
	}

	public String getMarginAsset() {
		return marginAsset;
	}

	public UnderlyingTypes getUnderlyingType() {
		return underlyingType;
	}

	public Set<UnderlyingSubTypes> getUnderlyingSubType() {
		return underlyingSubType;
	}

	public double getLiquidationFee() {
		return liquidationFee;
	}

	public double getMaintMarginPercent() {
		return maintMarginPercent;
	}

	public double getMarketTakeBound() {
		return marketTakeBound;
	}
	
	public Set<TimeInForce> getTimeInForce() {
		return timeInForce;
	}

	public long getDeliveryDate() {
		return deliveryDate;
	}
}
