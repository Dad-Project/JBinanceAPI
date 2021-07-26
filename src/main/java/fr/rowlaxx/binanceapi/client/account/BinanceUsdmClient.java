package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.usdm.UsdMMarketData;
import fr.rowlaxx.binanceapi.api.http.usdm.UsdMTrade;
import fr.rowlaxx.binanceapi.api.http.usdm.UsdMUserData;

public interface BinanceUsdmClient extends UsdMMarketData, UsdMTrade, UsdMUserData {}