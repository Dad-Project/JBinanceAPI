@ApiEndpoint (
	endpoint = "/api/v3/order/test",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = false,
	parameters = {},
	mandatory = {}
)
public void postTestNewOrder();

@ApiEndpoint (
	endpoint = "/api/v3/order",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
	mandatory = {true, true, true, false, false, false, false, false, false, false, false}
)
public NewOrder postNewOrder(String symbol, Enum side, Enum type, Enum timeInForce, double quantity, double quoteOrderQty, double price, String newClientOrderId, double stopPrice, double icebergQty, Enum newOrderRespType);

@ApiEndpoint (
	endpoint = "/api/v3/order",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
	mandatory = {true, true, true, false, false, false, false, false, false, false, false}
)
public NewOrder1 postNewOrder1(String symbol, Enum side, Enum type, Enum timeInForce, double quantity, double quoteOrderQty, double price, String newClientOrderId, double stopPrice, double icebergQty, Enum newOrderRespType);

@ApiEndpoint (
	endpoint = "/api/v3/order",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
	mandatory = {true, true, true, false, false, false, false, false, false, false, false}
)
public NewOrder2 postNewOrder2(String symbol, Enum side, Enum type, Enum timeInForce, double quantity, double quoteOrderQty, double price, String newClientOrderId, double stopPrice, double icebergQty, Enum newOrderRespType);

@ApiEndpoint (
	endpoint = "/api/v3/order",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.DELETE,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
	mandatory = {true, false, false, false}
)
public CancelOrder deleteCancelOrder(String symbol, long orderId, String origClientOrderId, String newClientOrderId);

@ApiEndpoint (
	endpoint = "api/v3/openOrders",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.DELETE,
	needSignature = true,
	parameters = {Parameters.symbol},
	mandatory = {true}
)
public List<CancelallOpenOrdersonaSymbol> deleteCancelallOpenOrdersonaSymbol(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/order",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
	mandatory = {true, false, false}
)
public QueryOrder getQueryOrder(String symbol, long orderId, String origClientOrderId);

@ApiEndpoint (
	endpoint = "/api/v3/openOrders",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.symbol},
	mandatory = {false}
)
public List<CurrentOpenOrders> getCurrentOpenOrders(String symbol);

@ApiEndpoint (
	endpoint = "/api/v3/allOrders",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {true, false, false, false, false}
)
public List<AllOrders> getAllOrders(String symbol, long orderId, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/order/oco",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.POST,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType},
	mandatory = {true, false, true, true, false, true, false, false, true, false, false, false, false}
)
public NewOCO postNewOCO(String symbol, String listClientOrderId, Enum side, double quantity, String limitClientOrderId, double price, double limitIcebergQty, String stopClientOrderId, double stopPrice, double stopLimitPrice, double stopIcebergQty, Enum stopLimitTimeInForce, Enum newOrderRespType);

@ApiEndpoint (
	endpoint = "/api/v3/orderList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.DELETE,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
	mandatory = {true, false, false, false}
)
public CancelOCO deleteCancelOCO(String symbol, long orderListId, String listClientOrderId, String newClientOrderId);

@ApiEndpoint (
	endpoint = "/api/v3/orderList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.orderListId, Parameters.origClientOrderId},
	mandatory = {false, false}
)
public QueryOCO getQueryOCO(long orderListId, String origClientOrderId);

@ApiEndpoint (
	endpoint = "/api/v3/allOrderList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
	mandatory = {false, false, false, false}
)
public List<QueryallOCO> getQueryallOCO(long fromId, long startTime, long endTime, int limit);

@ApiEndpoint (
	endpoint = "/api/v3/openOrderList",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
)
public List<QueryOpenOCO> getQueryOpenOCO();

@ApiEndpoint (
	endpoint = "/api/v3/account",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {},
	mandatory = {}
)
public AccountInformation getAccountInformation();

@ApiEndpoint (
	endpoint = "/api/v3/myTrades",
	baseEndpoint = BaseEndpoints.SPOT,
	method = Method.GET,
	needSignature = true,
	parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
	mandatory = {true, false, false, false, false, false}
)
public List<AccountTradeList> getAccountTradeList(String symbol, long orderId, long startTime, long endTime, long fromId, int limit);

