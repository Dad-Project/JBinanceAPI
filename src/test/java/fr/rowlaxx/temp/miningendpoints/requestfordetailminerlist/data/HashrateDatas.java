package fr.rowlaxx.temp.miningendpoints.requestfordetailminerlist.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class HashrateDatas extends JSavONObject {
	private static final long serialVersionUID = -2989768733168849142L;
	
	//Variables
	private int hashrate;
	private int reject;
	private long time;
	
	//Constructeurs
	public HashrateDatas(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getHashrate() {
		return this.hashrate;
	}
	
	public final int getReject() {
		return this.reject;
	}
	
	public final long getTime() {
		return this.time;
	}
}