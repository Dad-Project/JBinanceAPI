package fr.rowlaxx.binanceapi.core.spot;

import fr.rowlaxx.binanceapi.core.wallet.Balance;
import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class SpotAccountInformation extends JSavONObject {
	private static final long serialVersionUID = 2500421506551164994L;
	
	//Variables
	private String accountType;
	@MapKey(fieldName = "asset")
	private Map<String, Balance> balances;
	private int buyerCommission;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private int makerCommission;
	private List<String> permissions;
	private int sellerCommission;
	private int takerCommission;
	private int updateTime;
	
	//Constructeurs
	public SpotAccountInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAccountType() {
		return this.accountType;
	}
	
	public final Map<String, Balance> getBalances() {
		return balances;
	}
	
	public final Balance getBalance(String asset) {
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
	
	public final List<String> getPermissions() {
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