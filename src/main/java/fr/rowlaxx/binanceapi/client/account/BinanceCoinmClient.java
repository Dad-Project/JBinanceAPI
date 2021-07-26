package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.coinm.CoinMMarketData;
import fr.rowlaxx.binanceapi.api.http.coinm.CoinMTrade;
import fr.rowlaxx.binanceapi.api.http.coinm.CoinMUserData;

public interface BinanceCoinmClient extends CoinMMarketData, CoinMTrade, CoinMUserData{}
