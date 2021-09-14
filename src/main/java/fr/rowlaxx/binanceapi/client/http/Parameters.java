package fr.rowlaxx.binanceapi.client.http;

import java.util.Collection;

import fr.rowlaxx.binanceapi.core.api.bswap.LiquidityOperation;
import fr.rowlaxx.binanceapi.core.api.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.api.bswap.RemoveLiquidityOperationType;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshotTypes;

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
	email(String.class),
	enableBlvt,
	endTime(Long.class),
	featured,
	fromAccountType,
	fromEmail(String.class),
	fromId(Long.class),
	futuresType(Long.class),
	hashRate,
	icebergQty(Double.class),
	id(Long.class),
	interestBNBBurn,
	interval(Intervals.class),
	isFreeze(String.class),
	isIsolated,
	isolatedSymbol,
	isSortAsc,
	lendingType,
	limit(Integer.class),
	limitClientOrderId(String.class),
	limitIcebergQty(Double.class),
	listClientOrderId(String.class),
	listenKey(String.class),
	loanCoin,
	lot,
	name,
	needBtcValuation,
	network(String.class),
	newClientOrderId(String.class),
	newOrderRespType,
	offset(Integer.class),
	operation(LiquidityOperation.class),
	operationId(Long.class),
	orderId(Long.class),
	orderListId(Long.class),
	origClientOrderId(String.class),
	page(Integer.class),
	pageIndex,
	pageSize,
	poolId(Long.class),
	positionId,
	price(Double.class),
	productId,
	projectId,
	quantity(Double.class),
	quoteAsset(String.class),
	quoteId,
	quoteOrderQty(Double.class),
	quoteQty(Double.class),
	recvWindow(Integer.class),
	shareAmount(Double.class),
	side,
	sideEffectType,
	signature(String.class),
	size(Long.class),
	sort,
	sortBy,
	sortColumn,
	spotBNBBurn,
	startTime(Long.class),
	status(LiquidityOperationStatus.class, Integer.class),
	stopClientOrderId(String.class),
	stopIcebergQty(Double.class),
	stopLimitPrice(Double.class),
	stopLimitTimeInForce,
	stopPrice(Double.class),
	subAccountString(String.class),
	swapId(Long.class),
	symbol(String.class),
	symbols(String[].class, Collection.class),
	timeInForce,
	timestamp(Long.class),
	toAccountType,
	toEmail(String.class),
	tokenName(String.class),
	toPoolUser,
	transferDate,
	transFrom,
	transTo,
	txId,
	type(RemoveLiquidityOperationType.class, Integer.class, DailyAccountSnapshotTypes.class),
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
