package fr.rowlaxx.binanceapi.core.subaccount.transfer;

import org.json.JSONObject;

public class SpotAssetTransfer extends AssetTransfer {
	private static final long serialVersionUID = -4409178368839675415L;

	//Variables
	private TransferStatus status;
	
	//Constructeurs
	public SpotAssetTransfer(JSONObject json) {
		super(json);
	}
	
	//Getter
	public TransferStatus getStatus() {
		return status;
	}
}
