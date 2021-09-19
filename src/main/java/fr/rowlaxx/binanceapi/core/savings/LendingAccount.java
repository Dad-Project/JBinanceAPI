package fr.rowlaxx.binanceapi.core.savings;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class LendingAccount extends JSavONObject {
	private static final long serialVersionUID = 7712297511268282529L;
	
	//Variables
	private List<PositionAmount> positionAmountVos;
	private double totalAmountInBTC;
	private double totalAmountInUSDT;
	private double totalFixedAmountInBTC;
	private double totalFixedAmountInUSDT;
	private double totalFlexibleInBTC;
	private double totalFlexibleInUSDT;
	
	//Constructeurs
	public LendingAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<PositionAmount> getPositionAmountVos() {
		return this.positionAmountVos;
	}
	
	public final double getTotalAmountInBTC() {
		return this.totalAmountInBTC;
	}
	
	public final double getTotalAmountInUSDT() {
		return this.totalAmountInUSDT;
	}
	
	public final double getTotalFixedAmountInBTC() {
		return this.totalFixedAmountInBTC;
	}
	
	public final double getTotalFixedAmountInUSDT() {
		return this.totalFixedAmountInUSDT;
	}
	
	public final double getTotalFlexibleInBTC() {
		return this.totalFlexibleInBTC;
	}
	
	public final double getTotalFlexibleInUSDT() {
		return this.totalFlexibleInUSDT;
	}
}