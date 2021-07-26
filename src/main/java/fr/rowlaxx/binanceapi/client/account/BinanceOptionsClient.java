package fr.rowlaxx.binanceapi.client.account;

import fr.rowlaxx.binanceapi.api.http.options.OptionsMarketData;
import fr.rowlaxx.binanceapi.api.http.options.OptionsTrade;
import fr.rowlaxx.binanceapi.api.http.options.OptionsUserData;

public interface BinanceOptionsClient extends OptionsMarketData, OptionsTrade, OptionsUserData {}
