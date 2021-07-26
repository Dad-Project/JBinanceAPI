package fr.rowlaxx.binanceapi.exception;

public class BinanceException extends RuntimeException {
	private static final long serialVersionUID = -8315344501529412077L;

	//Constructeurs
	public BinanceException(String msg) {
		super(msg);
	}
	
}
