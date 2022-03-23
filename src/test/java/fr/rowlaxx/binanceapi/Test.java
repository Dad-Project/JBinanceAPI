package fr.rowlaxx.binanceapi;

import java.util.List;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.binanceapi.core.futures.marketdata.Period;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotExchangeInformation;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTrade;

public class Test {

	private final static BinanceClient client = Secret.client;
	
	
	public static void main(String[] args) {
		
		if (false) {
			for (Object o : client.spot().market().getOldTrades("BTCUSDT", 100, 0l))
				System.out.println(o);
			
			System.exit(0);
		}
		
				
		p("Usdm OldTrade " + client.usdm().market().getOldTrades("BTCUSDT", 1, null).get(0));
		p("Usdm RecentTrade " + client.usdm().market().getRecentTrades("BTCUSDT", 1).get(0));
		p("Usdm AggTrade " + client.usdm().market().getCompressedTrades("BTCUSDT", null, 1).get(0));
		p("Usdm Candle " + client.usdm().market().getCandlesticks("BTCUSDT", Intervals.DAY_1, 1).get(0));
		
		p("Usdm Continuous " + client.usdm().market().getContinuousContractCandlesticks("BTCUSDT", ContractTypes.PERPETUAL, Intervals.DAY_1, 1).get(0));
		p("Usdm Funding " + client.usdm().market().getFundingRateHistory("BTCUSDT", 1).get(0));
		p("Usdm GlobalRatio " + client.usdm().market().getGlobalAccountRatio("BTCUSDT", Period.DAY_1, 1).get(0));
		p("Usdm Index " + client.usdm().market().getIndexCandlesticks("BTCUSDT", Intervals.DAY_1, 1).get(0));
		p("Usdm Mark " + client.usdm().market().getMarkCandlesticks("BTCUSDT", Intervals.DAY_1, 1).get(0));
		p("Usdm OpenInterest " + client.usdm().market().getOpenInterestStatistics("BTCUSDT", Period.DAY_1, 1).get(0));
		p("Usdm TakerRatio " + client.usdm().market().getTakerBuySellVolume("BTCUSDT", Period.DAY_1, 1).get(0));
		p("Usdm AccountRatio " + client.usdm().market().getTopTraderAccountRatio("BTCUSDT", Period.DAY_1, 1).get(0));
		p("Usdm PositionRatio " + client.usdm().market().getTopTraderPositionRatio("BTCUSDT", Period.DAY_1, 1).get(0));
		
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}

}
