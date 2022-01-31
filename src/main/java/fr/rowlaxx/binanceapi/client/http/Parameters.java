package fr.rowlaxx.binanceapi.client.http;

import java.util.Collection;

import org.json.JSONObject;

public enum Parameters {

	address(String.class),
	addressTag(String.class),
	algo(String.class),
	amount(Double.class),
	archived(Boolean.class),
	asset(String.class, String[].class, Collection.class),
	assetRewards(String.class),
	baseAsset(String.class),
	batchOrders(JSONObject.class),
	beginTime(Long.class),
	clientOrderId(Long.class),
	clientOrderIds(Long[].class, Collection.class),
	clientTranId(String.class),
	code(String.class),
	coin(String.class),
	collateralAmount(Double.class),
	collateralCoin(String.class),
	configId(Integer.class),
	contractType(Enum.class),
	cost(Double.class),
	currency(String.class),
	current(Integer.class, Long.class),
	direction(Enum.class),
	email(String.class),
	enableBlvt(Boolean.class),
	endDate(Long.class),
	endTime(Long.class),
	endTimestamp(Long.class),
	featured(String.class),
	fromAccountType(String.class),
	fromEmail(String.class),
	fromId(Long.class),
	fromSymbol(String.class),
	futuresType(Enum.class),
	hashRate(Long.class),
	icebergQty(Double.class),
	id(Long.class),
	interestBNBBurn(Boolean.class),
	interval(Enum.class),
	ipAddress(String.class),
	ipRestrict(Boolean.class),
	isFreeze(Boolean.class),
	isIsolated(Boolean.class),
	isolatedSymbol(String.class),
	isSortAsc(Boolean.class),
	lendingType(Enum.class),
	limit(Integer.class),
	limitClientOrderId(String.class),
	limitIcebergQty(Double.class),
	listClientOrderId(String.class),
	listenKey(String.class),
	loanCoin(String.class),
	lot(Long.class),
	name(String.class),
	needBtcValuation(Boolean.class),
	network(String.class),
	newClientOrderId(String.class),
	newOrderRespType(Enum.class),
	offset(Integer.class),
	operation(Enum.class),
	operationId(Long.class),
	orderId(Long.class),
	orderIds(Long[].class, Collection.class),
	orderListId(Long.class),
	orders(Collection.class, Object[].class),
	orderType(Enum.class),
	origClientOrderId(String.class),
	page(Integer.class, Long.class),
	pageIndex(Integer.class),
	pageSize(Integer.class),
	pair(String.class),
	period(Enum.class),
	poolId(Long.class),
	positionId(Long.class),
	postOnly(Boolean.class),
	price(Double.class, String.class),
	productId(String.class),
	projectId(String.class),
	quantity(Double.class, String.class),
	quoteAsset(String.class),
	quoteId(String.class),
	quoteOrderQty(Double.class),
	quoteQty(Double.class),
	recordId(Long.class),
	recvWindow(Integer.class),
	reduceOnly(Boolean.class),
	rows(Integer.class),
	shareAmount(Double.class),
	side(Enum.class),
	sideEffectType(Enum.class),
	signature(String.class),
	size(Long.class, Integer.class),
	sort(Integer.class),
	sortBy(String.class),
	sortColumn(Boolean.class),
	spotBNBBurn(Boolean.class),
	startDate(Long.class),
	startTime(Long.class),
	startTimestamp(Long.class),
	status(Integer.class, Enum.class),
	stopClientOrderId(String.class),
	stopIcebergQty(Double.class),
	stopLimitPrice(Double.class),
	stopLimitTimeInForce,
	stopPrice(Double.class),
	subAccountApiKey(String.class),
	subAccountString(String.class),
	swapId(Long.class),
	symbol(String.class),
	symbols(String[].class, Collection.class),
	tier(String.class),
	timeInForce(Enum.class),
	timestamp(Long.class),
	toAccountType(String.class),
	toEmail(String.class),
	token(String.class),
	tokenName(String.class),
	toPoolUser(String.class),
	toSymbol(String.class),
	tradeType(Enum.class),
	transactionFeeFlag(Boolean.class),
	transactionType(String.class),
	transferDate(Long.class),
	transFrom(String.class),
	transTo(String.class),
	txId(Long.class),
	type(Integer.class, Enum.class),
	underlying(String.class),
	userName(String.class),
	vipLevel(Integer.class),
	withdrawOrderId(String.class),
	workerName(String.class),
	workerStatus(Integer.class);
	
	//Variables
	private final Class<?>[] types;
	
	//Constructeurs
	private Parameters(Class<?>... types) {
		for (Class<?> clazz : types)
			if (clazz == null)
				throw new IllegalArgumentException();
		this.types = types;
	}
	
	//Getters
	public Class<?>[] getTypes() {
		return types;
	}
	
	public boolean canBeAssignedWith(Class<?> clazz) {
		for (Class<?> c : this.types)
			if (c == clazz)
				return true;
		return false;
	}
	
	public boolean canBeAssignedWith(Object object) {
		return canBeAssignedWith(object.getClass());
	}
	
}
