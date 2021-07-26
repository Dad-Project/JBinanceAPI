package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.spot.SpotMarketData;
import fr.rowlaxx.binanceapi.api.http.spot.SpotTrade;
import fr.rowlaxx.binanceapi.api.http.spot.SpotUserData;

public interface BinanceSpotClient extends SpotMarketData, SpotTrade, SpotUserData{}