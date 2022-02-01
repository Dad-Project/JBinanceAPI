package fr.rowlaxx.binanceapi.core.coinm.trade;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountAsset;
import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountInformation;
import fr.rowlaxx.binanceapi.core.usdm.trade.CoinmAccountPosition;

import org.json.JSONObject;

public class CoinmAccountInformation extends FutureAccountInformation<FutureAccountAsset, CoinmAccountPosition> {
	private static final long serialVersionUID = 3177171119639825899L;
	
	//Constructeurs
	public CoinmAccountInformation(JSONObject json) {
		super(json);
	}
}