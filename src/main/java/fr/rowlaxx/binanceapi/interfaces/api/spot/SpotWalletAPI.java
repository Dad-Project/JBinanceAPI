package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.general.SystemStatus;
import fr.rowlaxx.binanceapi.core.wallet.AllCoinsInformation;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshotTypes;
import fr.rowlaxx.binanceapi.core.wallet.spot.SpotDailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface SpotWalletAPI {

	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public SystemStatus getSystemStatus(); 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/capital/config/getall", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "coin")
	public Map<String, AllCoinsInformation> getAllCoinsInformation();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/accountSnapshot", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false},
			defaultValues = {"SPOT", "", "", ""}
	)
	@RedirectResponse(path = "snapshotVos")
	public List<SpotDailyAccountSnapshot> getDailyAccountSnapshot(Long startTime, Long endTime, Integer limit);
	
	default List<SpotDailyAccountSnapshot> getDailyAccountSnapshot(Integer limit) {
		return getDailyAccountSnapshot(null, null, limit);
	}
	
	default List<SpotDailyAccountSnapshot> getDailyAccountSnapshot() {
		return getDailyAccountSnapshot(null, null, null);
	}
	
	/*
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/sapi/v1", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone */
}
