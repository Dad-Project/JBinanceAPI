package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class FuturesAccountSnapshot extends AccountSnapshot {
	private static final long serialVersionUID = -2047109621919437595L;
	
	//Variables
	@MapKey(fieldName = "asset")
	@JOValue(path = "data")
	private Map<String, FutureAsset> assets;
	
	@JOValue(path = "data")
	@MapKey(fieldName = "symbol")
	private Map<String, Position> position;
	
	//Constructeurs
	public FuturesAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, FutureAsset> getAssets() {
		return this.assets;
	}
	
	public final FutureAsset getAsset(String asset) {
		return this.assets.get(asset);
	}
	
	public final Map<String, Position> getPosition() {
		return this.position;
	}
	
	public final Position getPosition(String symbol) {
		return this.position.get(symbol);
	}
}