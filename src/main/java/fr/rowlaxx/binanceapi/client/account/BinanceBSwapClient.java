package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.bswap.BSwapMarketData;
import fr.rowlaxx.binanceapi.api.http.bswap.BSwapTrade;
import fr.rowlaxx.binanceapi.api.http.bswap.BSwapUserData;

public interface BinanceBSwapClient extends  BSwapMarketData, BSwapTrade, BSwapUserData {}