package fr.rowlaxx.binanceapi.core.nft;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class NFT extends JsavonObject {
	private static final long serialVersionUID = -430546438156789862L;

	private String network;
	private String contractAddress;
	private long tokenId;
	
	public NFT(JSONObject json) {
		super(json);
	}
	
	public final String getContractAddress() {
		return contractAddress;
	}
	
	public final String getNetwork() {
		return network;
	}
	
	public final long getTokenId() {
		return tokenId;
	}
}
