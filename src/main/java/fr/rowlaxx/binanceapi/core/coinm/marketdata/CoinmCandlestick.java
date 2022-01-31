package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.Candlestick;
import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class CoinmCandlestick extends JsavonArray implements Candlestick.Volume {
	private static final long serialVersionUID = -1885063134974002265L;
	
	//Variables
	@JAValue(index = 0) private long openTime;
	@JAValue(index = 1) private double open;
	@JAValue(index = 2) private double high;
	@JAValue(index = 3) private double low;
	@JAValue(index = 4) private double close;
	@JAValue(index = 5) private double volume;
	@JAValue(index = 6) private long closeTime;
	@JAValue(index = 7) private double baseAssetVolume;
	@JAValue(index = 8) private int numberOfTrades;
	@JAValue(index = 9) private double takerBuyBaseAssetVolume;
	@JAValue(index = 10) private double takerBuyQuoteAssetVolume;
	@JAValue(index = 11) private double ignore;
	
	//Constructeurs
	public CoinmCandlestick(JSONArray array) {
		super(array);
	}
	
	//Geters
	@Override
	public final long getOpenTime() {
		return this.openTime;
	}

	@Override
	public final long getCloseTime() {
		return this.closeTime;
	}

	@Override
	public final double getOpen() {
		return this.open;
	}

	@Override
	public final double getClose() {
		return this.close;
	}

	@Override
	public final double getLow() {
		return this.low;
	}

	@Override
	public final double getHigh() {
		return this.high;
	}
	
	@Override
	public final int getNumberOfTrades() {
		return this.numberOfTrades;
	}
	
	public final double getBaseAssetVolume() {
		return baseAssetVolume;
	}
	
	@Override
	public final double getTakerBuyBaseAssetVolume() {
		return this.takerBuyBaseAssetVolume;
	}
	
	public final double getIgnoreData() {
		return ignore;
	}
	
	@Override
	public final double getTakerBuyQuoteAssetVolume() {
		return this.takerBuyQuoteAssetVolume;
	}
	
	@Override
	public final double getVolume() {
		return this.volume;
	}
}