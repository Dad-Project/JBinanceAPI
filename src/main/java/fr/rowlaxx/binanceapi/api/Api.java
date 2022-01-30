package fr.rowlaxx.binanceapi.api;

public interface Api {

	public Platform getApiPlatform();
	public Protocol getApiProtocol();
	
	public static interface Spot extends Api {
		@Override
		default Platform getApiPlatform() {
			return Platform.SPOT;
		}
	}
	
	public static interface Usdm extends Api {
		@Override
		default Platform getApiPlatform() {
			return Platform.USDM;
		}
	}
	
	public static interface Coinm extends Api {
		@Override
		default Platform getApiPlatform() {
			return Platform.COINM;
		}
	}
	
	public static interface Options extends Api {
		@Override
		default Platform getApiPlatform() {
			return Platform.OPTIONS;
		}
	}
	
	public static interface Https extends Api {
		@Override
		default Protocol getApiProtocol() {
			return Protocol.HTTPS;
		}
	}
	
	public static interface WebSocket extends Api{
		@Override
		default Protocol getApiProtocol() {
			return Protocol.WEBSOCKET;
		}
	}
}