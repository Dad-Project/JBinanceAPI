package fr.rowlaxx.binanceapi.client.websocket;

import org.json.JSONArray;
import org.json.JSONObject;

public interface OnJsonReceived {

	public void onJson(JSONObject json);
	
	default void onJson(JSONArray json) {
		for (Object o : json)
			onJson((JSONObject)o);
	}
}
