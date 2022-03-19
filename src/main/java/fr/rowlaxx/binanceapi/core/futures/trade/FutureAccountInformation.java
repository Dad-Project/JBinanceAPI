package fr.rowlaxx.binanceapi.core.futures.trade;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.jsavon.JsavonObject;

public abstract class FutureAccountInformation<A extends FutureAccountAsset, P extends FutureAccountPosition> extends JsavonObject {
	private static final long serialVersionUID = -5716572066895383023L;

	@MapKey(fieldName = "asset") private Map<String, A> assets;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private int feeTier;
	@MapKey(fieldName = "symbol") private Map<String, P> positions;
	private long updateTime;
	
	public FutureAccountInformation(JSONObject json) {
		super(json);
	}
	
	public final boolean canDeposit() {
		return canDeposit;
	}
	
	public final boolean canTrade() {
		return canTrade;
	}
	
	public final boolean canWithdraw() {
		return canWithdraw;
	}
	
	public final long getUpdateTime() {
		return updateTime;
	}
	
	public final int getFeeTier() {
		return feeTier;
	}
	
	public final Map<String, A> getAssets() {
		return assets;
	}
	
	public final Map<String, P> getPositions() {
		return positions;
	}
	
	public final A getAsset(String asset) {
		return assets.get(asset);
	}
	
	public final P getPosition(String symbol) {
		return positions.get(symbol);
	}
}
