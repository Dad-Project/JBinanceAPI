package fr.rowlaxx.temp.miningendpoints.earningslist.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AccountProfits extends JSavONObject {
	private static final long serialVersionUID = -2079631857072927016L;
	
	//Variables
	private String coinName;
	private long dayHashRate;
	private String hashTransfer;
	private double profitAmount;
	private int status;
	private long time;
	private String transferAmount;
	private int type;
	
	//Constructeurs
	public AccountProfits(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoinName() {
		return this.coinName;
	}
	
	public final long getDayHashRate() {
		return this.dayHashRate;
	}
	
	public final String getHashTransfer() {
		return this.hashTransfer;
	}
	
	public final double getProfitAmount() {
		return this.profitAmount;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final String getTransferAmount() {
		return this.transferAmount;
	}
	
	public final int getType() {
		return this.type;
	}
}