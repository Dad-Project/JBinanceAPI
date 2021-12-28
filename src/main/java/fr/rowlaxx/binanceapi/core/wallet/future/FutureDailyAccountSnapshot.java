package fr.rowlaxx.binanceapi.core.wallet.future;

import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class FutureDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = -2047109621919437595L;
	
	//Variables
	@MapKey(fieldName = "asset")
	@JOValue(path = "data")
	private Map<String, Asset> assets;
	
	@JOValue(path = "data")
	@MapKey(fieldName = "symbol")
	private Map<String, Position> position;
	
	//Constructeurs
	public FutureDailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, Asset> getAssets() {
		return this.assets;
	}
	
	public final Asset getAsset(String asset) {
		return this.assets.get(asset);
	}
	
	public final Map<String, Position> getPosition() {
		return this.position;
	}
	
	public final Position getPosition(String symbol) {
		return this.position.get(symbol);
	}
}