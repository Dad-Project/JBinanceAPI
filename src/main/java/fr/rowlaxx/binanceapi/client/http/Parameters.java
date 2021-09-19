package fr.rowlaxx.binanceapi.client.http;

import java.util.Collection;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperationStatus;
import fr.rowlaxx.binanceapi.core.bswap.LiquidityOperations;
import fr.rowlaxx.binanceapi.core.bswap.RemoveLiquidityOperationTypes;
import fr.rowlaxx.binanceapi.core.future.Direction;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.order.OrderResponseTypes;
import fr.rowlaxx.binanceapi.core.order.OrderSide;
import fr.rowlaxx.binanceapi.core.order.TimeInForce;
import fr.rowlaxx.binanceapi.core.order.future.FutureOrderTypes;
import fr.rowlaxx.binanceapi.core.order.margin.SideEffectType;
import fr.rowlaxx.binanceapi.core.subaccount.transfer.FuturesType;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshotTypes;
import fr.rowlaxx.binanceapi.core.wallet.UniversalTransferTypes;

public enum Parameters {

	address(String.class),
	addressTag(String.class),
	algo(String.class),
	amount(Double.class),
	archived(Boolean.class),
	asset(String.class, String[].class, Collection.class),
	baseAsset(String.class),
	batchOrders(JSONObject.class),
	beginTime(Long.class),
	coin(String.class),
	collateralAmount(Double.class),
	collateralCoin(String.class),
	configId(Integer.class),
	cost(Double.class),
	current(Integer.class, Long.class),
	direction(Direction.class),
	email(String.class),
	enableBlvt(Boolean.class),
	endTime(Long.class),
	endTimestamp(Long.class),
	featured(String.class),
	fromAccountType(String.class),
	fromEmail(String.class),
	fromId(Long.class),
	fromSymbol(String.class),
	futuresType(FuturesType.class),
	hashRate(Long.class),
	icebergQty(Double.class),
	id(Long.class),
	interestBNBBurn(Boolean.class),
	interval(Intervals.class),
	isFreeze(Boolean.class),
	isIsolated(Boolean.class),
	isolatedSymbol(String.class),
	isSortAsc(Boolean.class),
	lendingType(String.class),
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
	newOrderRespType(OrderResponseTypes.class),
	offset(Integer.class),
	operation(LiquidityOperations.class),
	operationId(Long.class),
	orderId(Long.class),
	orderListId(Long.class),
	origClientOrderId(String.class),
	page(Integer.class, Long.class),
	pageIndex(Integer.class),
	pageSize(Integer.class),
	poolId(Long.class),
	positionId(Long.class),
	price(Double.class, String.class),
	productId(String.class),
	projectId(String.class),
	quantity(Double.class, String.class),
	quoteAsset(String.class),
	quoteId(String.class),
	quoteOrderQty(Double.class),
	quoteQty(Double.class),
	recvWindow(Integer.class),
	rows(Integer.class),
	shareAmount(Double.class),
	side(OrderSide.class),
	sideEffectType(SideEffectType.class),
	signature(String.class),
	size(Long.class, Integer.class),
	sort(Integer.class),
	sortBy(String.class),
	sortColumn(Boolean.class),
	spotBNBBurn(Boolean.class),
	startTime(Long.class),
	startTimestamp(Long.class),
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
	timeInForce(TimeInForce.class),
	timestamp(Long.class),
	toAccountType(String.class),
	toEmail(String.class),
	tokenName(String.class),
	toPoolUser(String.class),
	toSymbol(String.class),
	tradeType(OrderSide.class),
	transactionFeeFlag(Boolean.class),
	transactionType(String.class),
	transferDate(Long.class),
	transFrom(String.class),
	transTo(String.class),
	txId(Long.class),
	type(RemoveLiquidityOperationTypes.class, Integer.class, DailyAccountSnapshotTypes.class, UniversalTransferTypes.class, FutureOrderTypes.class),
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
