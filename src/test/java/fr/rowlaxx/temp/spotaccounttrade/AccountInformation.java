package fr.rowlaxx.temp.spotaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.spotaccounttrade.accountinformation.Balances;

import java.util.List;

import org.json.JSONObject;

public class AccountInformation extends JSavONObject {
	private static final long serialVersionUID = 2500421506551164994L;
	
	//Variables
	private String accountType;
	private List<Balances> balances;
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
	public AccountInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAccountType() {
		return this.accountType;
	}
	
	public final List<Balances> getBalances() {
		return this.balances;
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