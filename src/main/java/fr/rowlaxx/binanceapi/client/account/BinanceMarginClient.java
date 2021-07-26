package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.margin.MarginMarketData;
import fr.rowlaxx.binanceapi.api.http.margin.MarginTrade;
import fr.rowlaxx.binanceapi.api.http.margin.MarginUserData;

public interface BinanceMarginClient extends MarginMarketData, MarginTrade, MarginUserData{}