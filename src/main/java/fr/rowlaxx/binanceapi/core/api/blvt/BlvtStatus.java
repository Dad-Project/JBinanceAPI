package fr.rowlaxx.binanceapi.enums.blvt;

public enum Status {

	//La liste
	success("S"),
	pending("P"),
	failure("F");
	
	//Variables
	private final String toString;
	
	//Constructeurs
	private Status(String toString) {
		this.toString = toString;
	}
	
	//Method
	@Override
	public String toString() {
		return toString;
	}
	
}
