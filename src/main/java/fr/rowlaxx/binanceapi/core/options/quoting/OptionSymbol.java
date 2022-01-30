package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.SimpleSymbol;
import fr.rowlaxx.binanceapi.core2.order.options.OptionsContractTypes;

public class OptionSymbol extends SimpleSymbol {
	private static final long serialVersionUID = 3638739540698918134L;

	//Variables
	private double leverage;
	private OptionsContractTypes side;
	private double minInitialMargin;
	private double maketFeeRate;
	private double minAutoReduceMargin;
	private String underlying;
	private double autoReduceMargin;
	private double initialMargin;
	private long expiryDate;
	private int unit;
	private double maintenanceMargin;
	private int contractId;
	private int quantityScale;
	private int priceScale;
	private double takerFeeRate;
	private int id;
	private double maxQty;
	private double minMaintenanceMargin;
	private double strikePrice;
	private double minQty;
	
	//Constructeurs
	public OptionSymbol(JSONObject response) {
		super(response);
	}
	
	//Getters
	public double getAutoReduceMargin() {
		return autoReduceMargin;
	}
	
	public int getContractId() {
		return contractId;
	}
	
	public long getExpiryDate() {
		return expiryDate;
	}
	
	public int getId() {
		return id;
	}
	
	public double getInitialMargin() {
		return initialMargin;
	}
	
	public double getLeverage() {
		return leverage;
	}
	
	public double getMaintenanceMargin() {
		return maintenanceMargin;
	}
	
	public double getMaketFeeRate() {
		return maketFeeRate;
	}
	
	public double getMaxQty() {
		return maxQty;
	}
	
	public double getMinAutoReduceMargin() {
		return minAutoReduceMargin;
	}
	
	public double getMinInitialMargin() {
		return minInitialMargin;
	}
	
	public double getMinMaintenanceMargin() {
		return minMaintenanceMargin;
	}
	
	public double getMinQty() {
		return minQty;
	}
	
	public int getPriceScale() {
		return priceScale;
	}
	
	public int getQuantityScale() {
		return quantityScale;
	}
	
	public OptionsContractTypes getSide() {
		return side;
	}
	
	public double getStrikePrice() {
		return strikePrice;
	}
	
	public double getTakerFeeRate() {
		return takerFeeRate;
	}
	
	public String getUnderlying() {
		return underlying;
	}
	
	public int getUnit() {
		return unit;
	}
}