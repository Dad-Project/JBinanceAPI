package fr.rowlaxx.binanceapi.core.api.blvt;

public enum BlvtStatus {

	//La liste
	success("S"),
	pending("P"),
	failure("F");
	
	//Variables
	private final String toString;
	
	//Constructeurs
	private BlvtStatus(String toString) {
		this.toString = toString;
	}
	
	//Method
	@Override
	public String toString() {
		return toString;
	}
	
}
