package fr.rowlaxx.binanceapi.core.blvt;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class BasketStream extends JsavonObject {
	private static final long serialVersionUID = 8309375304903539339L;

	//Variables
	@JOValue(key = "s")
	private String symbol;
	@JOValue(key = "n")
	private double position;
	
	//Getters
	public double getPosition() {
		return position;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
