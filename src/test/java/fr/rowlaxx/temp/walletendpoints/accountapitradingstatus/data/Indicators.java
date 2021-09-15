package fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.indicators.BTCUSDT;
import fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.indicators.ETHUSDT;

import java.util.List;

import org.json.JSONObject;

public class Indicators extends JSavONObject {
	private static final long serialVersionUID = -3035960310660456157L;
	
	//Variables
	private List<BTCUSDT> BTCUSDT;
	private List<ETHUSDT> ETHUSDT;
	
	//Constructeurs
	public Indicators(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<BTCUSDT> getBTCUSDT() {
		return this.BTCUSDT;
	}
	
	public final List<ETHUSDT> getETHUSDT() {
		return this.ETHUSDT;
	}
}