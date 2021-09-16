package fr.rowlaxx.binanceapi.client.http;

import java.util.Collection;

import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperations;
import fr.rowlaxx.binanceapi.core.bswap.RemoveLiquidityOperationTypes;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.FuturesType;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshotTypes;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferTypes;

public enum Parameters {

	address(String.class),
	addressTag(String.class),
	algo,
	amount(Double.class),
	archived,
	asset(String.class, String[].class, Collection.class),
	baseAsset(String.class),
	coin(String.class),
	collateralAmount,
	collateralCoin,
	configId,
	cost(Double.class),
	current(Integer.class),
	direction,
	email(String.class),
	enableBlvt(Boolean.class),
	endTime(Long.class),
	featured,
	fromAccountType(String.class),
	fromEmail(String.class),
	fromId(Long.class),
	fromSymbol(String.class),
	futuresType(FuturesType.class),
	hashRate,
	icebergQty(Double.class),
	id(Long.class),
	interestBNBBurn,
	interval(Intervals.class),
	isFreeze(Boolean.class),
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
	name(String.class),
	needBtcValuation(Boolean.class),
	network(String.class),
	newClientOrderId(String.class),
	newOrderRespType,
	offset(Integer.class),
	operation(LiquidityOperations.class),
	operationId(Long.class),
	orderId(Long.class),
	orderListId(Long.class),
	origClientOrderId(String.class),
	page(Integer.class, Long.class),
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
	size(Long.class, Integer.class),
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
	toAccountType(String.class),
	toEmail(String.class),
	tokenName(String.class),
	toPoolUser,
	toSymbol(String.class),
	transactionFeeFlag(Boolean.class),
	transferDate(Long.class),
	transFrom,
	transTo,
	txId,
	type(RemoveLiquidityOperationTypes.class, Integer.class, DailyAccountSnapshotTypes.class, UniversalTransferTypes.class),
	userName,
	vipLevel,
	withdrawOrderId(String.class),
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
