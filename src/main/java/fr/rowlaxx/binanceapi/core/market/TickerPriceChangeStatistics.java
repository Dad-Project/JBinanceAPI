package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class TickerPriceChangeStatistics extends BinanceResponseJSON{

	@JsonValue private String symbol;
	@JsonValue private double
				priceChange,
				priceChangePercent, 
				weightedAvgPrice,
				prevClosePrice, 
				lastPrice, 
				lastQty, 
				bidPrice, 
				askPrice,
				openPrice,
				highPrice,
				lowPrice,
				volume,
				quoteVolume;
	@JsonValue private long
				openTime,
				closeTime;
	@JsonValue private int
				firstId,
				lastId,
				count;
				
	public TickerPriceChangeStatistics(JSONObject response) {
		super(response);
	}

	public String getSymbol() {
		return symbol;
	}

	public double getPriceChange() {
		return priceChange;
	}

	public double getPriceChangePercent() {
		return priceChangePercent;
	}

	public double getWeightedAvgPrice() {
		return weightedAvgPrice;
	}

	public double getPrevClosePrice() {
		return prevClosePrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public double getLastQty() {
		return lastQty;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public double getAskPrice() {
		return askPrice;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getVolume() {
		return volume;
	}

	public double getQuoteVolume() {
		return quoteVolume;
	}

	public long getOpenTime() {
		return openTime;
	}

	public long getCloseTime() {
		return closeTime;
	}

	public int getFirstId() {
		return firstId;
	}

	public int getLastId() {
		return lastId;
	}

	public int getCount() {
		return count;
	}

}
