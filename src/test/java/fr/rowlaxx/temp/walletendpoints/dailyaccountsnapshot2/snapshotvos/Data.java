package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos.data.Assets;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos.data.Position;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -2047109621919437595L;
	
	//Variables
	private List<Assets> assets;
	private List<Position> position;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Assets> getAssets() {
		return this.assets;
	}
	
	public final List<Position> getPosition() {
		return this.position;
	}
}