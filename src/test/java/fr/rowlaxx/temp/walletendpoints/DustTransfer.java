package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dusttransfer.TransferResult;

import java.util.List;

import org.json.JSONObject;

public class DustTransfer extends JSavONObject {
	private static final long serialVersionUID = -9189583470562999350L;
	
	//Variables
	private double totalServiceCharge;
	private double totalTransfered;
	private List<TransferResult> transferResult;
	
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
	
	public final List<TransferResult> getTransferResult() {
		return this.transferResult;
	}
}