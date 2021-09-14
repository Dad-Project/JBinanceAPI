package fr.rowlaxx.binanceapi.core.wallet.future;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;

public class FutureDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = 1965103242703120696L;

	//Constructeurs
	public FutureDailyAccountSnapshot(JSONObject json) {
		super(json);
	}

}
