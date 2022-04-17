package fr.rowlaxx.binanceapi.api.spot;

public class BLVTAPI {

	//Variables
	private final BLVTHttpAPI http;
	private BLVTStreamAPI stream;
	
	//Constructeurs
	public BLVTAPI(BLVTHttpAPI http) {
		this.http = http;
	}
	
	//Methodes
	public BLVTHttpAPI http() {
		return http;
	}
	
	public BLVTStreamAPI stream() {
		if (stream == null)
			stream = new BLVTStreamAPI();
		return stream;
	}
	
}
