package fr.rowlaxx.binanceapi.core.spot.wallet;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;
import java.util.Map;

import org.json.JSONObject;

public class DustTransfer extends JsavonObject {
	private static final long serialVersionUID = -9189583470562999350L;
	
	//Variables
	@JOValue(key = {"totalServiceCharge", "totalServiceChargeAmount"})
	private double totalServiceCharge;
	
	@JOValue(key = {"totalTransfered", "totalTransferedAmount"})
	private double totalTransfered;
	
	@JOValue(key = {"userAssetDribbletDetails", "transferResult"})
	@MapKey(fieldName = "fromAsset")
	private Map<String, DustTransferDetails> transferDetails;
	
	//Constructeurs
	public DustTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getTotalServiceCharge() {
		return this.totalServiceCharge;
	}
	
	public final double getTotalTransfered() {
		return this.totalTransfered;
	}
	
	public final Map<String, DustTransferDetails> getTransferDetails() {
		return this.transferDetails;
	}
	
	public final DustTransferDetails getTransferDetail(String asset) {
		return this.transferDetails.get(asset);
	}
}