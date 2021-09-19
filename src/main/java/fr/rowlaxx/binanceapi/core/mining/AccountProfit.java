package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

public class AccountProfit extends Profit {
	private static final long serialVersionUID = -2079631857072927016L;
	
	//Variables
	private long dayHashRate;
	private Double hashTransfer;
	private Double transferAmount;
	
	//Constructeurs
	public AccountProfit(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getDayHashRate() {
		return this.dayHashRate;
	}
	
	public final Double getHashTransfer() {
		return this.hashTransfer;
	}
	
	public final Double getTransferAmount() {
		return this.transferAmount;
	}
}