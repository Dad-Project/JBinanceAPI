package fr.rowlaxx.binanceapi.exceptions;

public class BinanceHttpClientException extends BinanceException {
	private static final long serialVersionUID = -7106592156821832037L;

	//Variables
	private final int code;
	
	//Constructeurs
	public BinanceHttpClientException(String msg, int code) {
		super(msg);
		this.code = code;
	}
	
	public BinanceHttpClientException(String msg) {
		this(msg, 0);
	}
	
	//Getter
	public int getCode() {
		return code;
	}
	
	@Override
	public String getMessage() {
		if (code == 0)
			return super.getMessage();
		return "code=" + code + " : " + super.getMessage(); 
	}

}
