@ApiEndpoint (
	endpoint = "/api/v3/ping",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {},
	mandatory = {}
}
public void getTestConnectivity();

@ApiEndpoint (
	endpoint = "/api/v3/time",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {},
	mandatory = {}
}
public CheckServerTime getCheckServerTime();

@ApiEndpoint (
	endpoint = "/api/v3/exchangeInfo",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {},
	mandatory = {}
}
public ExchangeInformation getExchangeInformation();

@ApiEndpoint (
	endpoint = "/api/v3/depth",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol, Parameters.limit},
	mandatory = {true, false}
}
public OrderBook getOrderBook(String symbol, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/trades",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol, Parameters.limit},
	mandatory = {true, false}
}
public List<RecentTradesList> getRecentTradesList(String symbol, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/historicalTrades",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
	mandatory = {true, false, false}
}
public List<OldTradeLookup> getOldTradeLookup(String symbol, int limit, long fromId);

@ApiEndpoint (
	endpoint = "/api/v3/aggTrades",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, false, false, false, false}
}
public List<CompressedAggregateTradesList> getCompressedAggregateTradesList(String symbol, long fromId, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/klines",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, true, false, false, false}
}
public List<KlineCandlestickData> getKlineCandlestickData(String symbol, Enum interval, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/avgPrice",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {true}
}
public CurrentAveragePrice getCurrentAveragePrice(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/24hr",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public 24hrTickerPriceChangeStatistics get24hrTickerPriceChangeStatistics(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/24hr",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public List<24hrTickerPriceChangeStatistics1> get24hrTickerPriceChangeStatistics1(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/price",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public SymbolPriceTicker getSymbolPriceTicker(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/price",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public List<SymbolPriceTicker1> getSymbolPriceTicker1(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/bookTicker",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public SymbolOrderBookTicker getSymbolOrderBookTicker(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/ticker/bookTicker",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = false,
	parameters = {Parameters.symbol},
	mandatory = {false}
}
public List<SymbolOrderBookTicker1> getSymbolOrderBookTicker1(String symbol);

