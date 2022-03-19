package fr.rowlaxx.binanceapi.core.spot.trade;

import fr.rowlaxx.binanceapi.core.Asset;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.jsavon.JsavonObject;

import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class AccountInformation extends JsavonObject {
	private static final long serialVersionUID = 2500421506551164994L;
	
	//Variables
	private String accountType;
	@MapKey(fieldName = "asset")
	private Map<String, Asset> balances;
	private int buyerCommission;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private int makerCommission;
	private Set<String> permissions;
	private int sellerCommission;
	private int takerCommission;
	private int updateTime;
	
	//Constructeurs
	public AccountInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAccountType() {
		return this.accountType;
	}
	
	public final Map<String, Asset> getBalances() {
		return balances;
	}
	
	public final Asset getBalance(String asset) {
		return balances.get(asset);
	}
	
	public final int getBuyerCommission() {
		return this.buyerCommission;
	}
	
	public final boolean isCanDeposit() {
		return this.canDeposit;
	}
	
	public final boolean isCanTrade() {
		return this.canTrade;
	}
	
	public final boolean isCanWithdraw() {
		return this.canWithdraw;
	}
	
	public final int getMakerCommission() {
		return this.makerCommission;
	}
	
	public final Set<String> getPermissions() {
		return this.permissions;
	}
	
	public final int getSellerCommission() {
		return this.sellerCommission;
	}
	
	public final int getTakerCommission() {
		return this.takerCommission;
	}
	
	public final int getUpdateTime() {
		return this.updateTime;
	}
}