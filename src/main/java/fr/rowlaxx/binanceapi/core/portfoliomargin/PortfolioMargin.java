package fr.rowlaxx.binanceapi.core.portfoliomargin;

import fr.rowlaxx.jsavon.JsavonObject;

public class PortfolioMargin extends JsavonObject {
	private static final long serialVersionUID = -7944811103308672180L;

	//Variables
	private double uniMMR;
	private double accountEquity;
	private double accountMaintMargin;
	private AccountStatus accountStatus;
	
	//Getters
	public double getAccountEquity() {
		return accountEquity;
	}
	
	public double getAccountMaintMargin() {
		return accountMaintMargin;
	}
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	
	public double getUniMMR() {
		return uniMMR;
	}
}
