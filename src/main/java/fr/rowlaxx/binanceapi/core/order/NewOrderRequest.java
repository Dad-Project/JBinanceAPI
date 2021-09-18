package fr.rowlaxx.binanceapi.core.order;

import fr.rowlaxx.binanceapi.core.order.future.FutureOrderRequest;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOrderRequest;
import fr.rowlaxx.binanceapi.core.order.options.OptionsOrderRequest;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOrderRequest;

public final class NewOrderRequest {
	
	public static SpotOrderRequest.Builder spot(){
		return SpotOrderRequest.newSpotBuilder();
	}

	public static MarginOrderRequest.Builder margin(){
		return MarginOrderRequest.newMarginBuilder();
	}
	
	public static SpotOCOOrderRequest.Builder spotOCO(){
		return SpotOCOOrderRequest.newSpotBuilder();
	}
	
	public static MarginOCOOrderRequest.Builder marginOCO(){
		return MarginOCOOrderRequest.newMarginBuilder();
	}
	
	public static FutureOrderRequest.Builder futures(){
		return FutureOrderRequest.newBuilder();
	}
	
	public static OptionsOrderRequest.Builder options() {
		return OptionsOrderRequest.newBuilder();
	}	
}