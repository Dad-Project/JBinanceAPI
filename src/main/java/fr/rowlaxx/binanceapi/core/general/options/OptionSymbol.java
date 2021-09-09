package fr.rowlaxx.binanceapi.core.general.options;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Symbol;
import fr.rowlaxx.binanceapi.core.order.options.OptionContractTypes;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class OptionSymbol extends Symbol {
	private static final long serialVersionUID = 3638739540698918134L;

	//Variables
	@JOValue double leverage;
	@JOValue private OptionContractTypes side;
	@JOValue private double minInitialMargin;
	@JOValue private double maketFeeRate;
	@JOValue private double minAutoReduceMargin;
	@JOValue private String underlying;
	@JOValue private double autoReduceMargin;
	@JOValue private double initialMargin;
	@JOValue private long expiryDate;
	@JOValue private int unit;
	@JOValue private double maintenanceMargin;
	@JOValue private int contractId;
	@JOValue private int quantityScale;
	@JOValue private int priceScale;
	@JOValue private double takerFeeRate;
	@JOValue private int id;
	@JOValue private double maxQty;
	@JOValue private double minMaintenanceMargin;
	@JOValue private double strikePrice;
	@JOValue private double minQty;
	
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
	
	public OptionContractTypes getSide() {
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