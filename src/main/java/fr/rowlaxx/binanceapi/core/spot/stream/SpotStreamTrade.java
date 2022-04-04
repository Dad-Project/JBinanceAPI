package fr.rowlaxx.binanceapi.core.spot.stream;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.SideableTrade;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SpotStreamTrade extends SideableTrade {
	private static final long serialVersionUID = -2572330113881257652L;
	
	//Variables
	@JOValue(key = "b")
	private long buyerOrderId;
	@JOValue(key = "a")
	private long sellerOrderId;
	
	//Constructeurs
	public SpotStreamTrade(JSONObject json) {
		super(json);
	}
	
	//Getter
	public long getBuyerOrderId() {
		return buyerOrderId;
	}
	
	public long getSellerOrderId() {
		return sellerOrderId;
	}
}
