package fr.rowlaxx.binanceapi.core.api.spot;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.market.Candlestick;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValueArray;

public class SpotCandlestick extends BinanceResponseJSON implements Candlestick {
	private static final long serialVersionUID = -167067447301341225L;

	//Variables
	@JsonValueArray(index = 0) private long openTime;
	@JsonValueArray(index = 1) private double open;
	@JsonValueArray(index = 2) private double high;
	@JsonValueArray(index = 3) private double low;
	@JsonValueArray(index = 4) private double close;
	@JsonValueArray(index = 5) private double volume;
	@JsonValueArray(index = 6) private long closeTime;
	@JsonValueArray(index = 7) private double quoteAssetVolume;
	@JsonValueArray(index = 8) private long numberOfTrades;
	@JsonValueArray(index = 9) private double takerBuyBaseAssetVolume;
	@JsonValueArray(index = 10) private double takerBuyQuoteAssetVolume;
	
	//Constructeurs
	public SpotCandlestick(JSONArray response) {
		super(response);
	}

	//Getters
	@Override
	public long getOpenTime() {
		return openTime;
	}

	@Override
	public long getCloseTime() {
		return closeTime;
	}

	@Override
	public double getOpen() {
		return open;
	}

	@Override
	public double getClose() {
		return close;
	}

	@Override
	public double getLow() {
		return low;
	}

	@Override
	public double getHigh() {
		return high;
	}
	
	public long getNumberOfTrades() {
		return numberOfTrades;
	}
	
	public double getQuoteAssetVolume() {
		return quoteAssetVolume;
	}
	
	public double getTakerBuyBaseAssetVolume() {
		return takerBuyBaseAssetVolume;
	}
	
	public double getTakerBuyQuoteAssetVolume() {
		return takerBuyQuoteAssetVolume;
	}

	public double getVolume() {
		return volume;
	}
}
