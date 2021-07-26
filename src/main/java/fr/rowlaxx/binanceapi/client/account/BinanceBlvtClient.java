package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.blvt.BlvtMarketDataAPI;
import fr.rowlaxx.binanceapi.api.http.blvt.BlvtTradeAPI;
import fr.rowlaxx.binanceapi.api.http.blvt.BlvtUserDataAPI;

public interface BinanceBlvtClient extends BlvtMarketDataAPI, BlvtTradeAPI, BlvtUserDataAPI {}