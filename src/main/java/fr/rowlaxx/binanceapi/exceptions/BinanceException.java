package fr.rowlaxx.binanceapi.exceptions;

public class BinanceException extends RuntimeException {
	private static final long serialVersionUID = -8315344501529412077L;

	//Constructeurs
	public BinanceException(String msg) {
		super(msg);
	}
	
	public BinanceException() {
		super();
	}
	
	public BinanceException(Throwable cause) {
		super(cause);
	}
	
	public BinanceException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
