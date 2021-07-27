package fr.rowlaxx.binanceapi.client.http;

import fr.rowlaxx.binanceapi.core.api.bswap.LiquidityOperation;
import fr.rowlaxx.binanceapi.core.api.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.api.bswap.RemoveLiquidityOperationType;
import fr.rowlaxx.binanceapi.core.market.Intervals;

public enum Parameters {

	address,
	addressTag,
	algo,
	amount(Double.class),
	archived,
	asset(String.class),
	baseAsset(String.class),
	coin(String.class),
	collateralAmount,
	collateralCoin,
	configId,
	cost(Double.class),
	current,
	direction,
	email,
	enableBlvt,
	endTime(Long.class),
	featured,
	fromAccountType,
	fromEmail,
	fromId,
	futuresType,
	hashRate,
	icebergQty,
	id(Long.class),
	interestBNBBurn,
	interval(Intervals.class),
	isFreeze,
	isIsolated,
	isolatedSymbol,
	isSortAsc,
	lendingType,
	limit(Integer.class),
	limitClientOrderId,
	limitIcebergQty,
	listClientOrderId,
	listenKey,
	loanCoin,
	lot,
	name,
	needBtcValuation,
	network,
	newClientOrderId,
	newOrderRespType,
	offset,
	operation(LiquidityOperation.class),
	operationId(Long.class),
	orderId,
	orderListId,
	origClientOrderId,
	page,
	pageIndex,
	pageSize,
	poolId(Long.class),
	positionId,
	price,
	productId,
	projectId,
	quantity(Double.class),
	quoteAsset(String.class),
	quoteId,
	quoteOrderQty,
	quoteQty(Double.class),
	recvWindow(Integer.class),
	shareAmount(Double.class),
	side,
	sideEffectType,
	signature(String.class),
	size,
	sort,
	sortBy,
	sortColumn,
	spotBNBBurn,
	startTime(Long.class),
	status(LiquidityOperationStatus.class),
	stopClientOrderId,
	stopIcebergQty,
	stopLimitPrice,
	stopLimitTimeInForce,
	stopPrice,
	subAccountString,
	swapId(Long.class),
	symbol(String.class),
	symbols,
	timeInForce,
	timestamp(Long.class),
	toAccountType,
	toEmail,
	tokenName(String.class),
	toPoolUser,
	transferDate,
	transFrom,
	transTo,
	txId,
	type(RemoveLiquidityOperationType.class),
	userName,
	vipLevel,
	withdrawOrderId,
	workerName,
	workerStatus;
	
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
