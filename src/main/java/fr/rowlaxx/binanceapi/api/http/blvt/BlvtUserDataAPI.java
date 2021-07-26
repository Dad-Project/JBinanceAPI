package fr.rowlaxx.binanceapi.api.http.blvt;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtRedemptionRecord;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtSubscriptionRecord;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtUserLimitInfo;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;

public interface BlvtUserDataAPI {

	//Query Subscription Record (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/subscribe/record",
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.id, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	default List<BlvtSubscriptionRecord> querySubscriptionRecords(String tokenName, Long id, Long startTime, Long endTime, Integer limit) {
		if (limit != null)
			if (limit <= 0 || limit > 1000)
				throw new IllegalArgumentException("limit must be between 1 and 1000. limit=" + limit);
		return null;
	}
	
	default BlvtSubscriptionRecord querySubscriptionRecord(long id) {
		try{
			return querySubscriptionRecords(null, id, null, null, null).get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	default List<BlvtSubscriptionRecord> querySubscriptionRecords(String tokenName, Long startTime, Long endTime, Integer limit) {
		return querySubscriptionRecords(tokenName, null, startTime, endTime, limit);
	}
	
	default List<BlvtSubscriptionRecord> querySubscriptionRecords(String tokenName, Integer limit) {
		return querySubscriptionRecords(tokenName, null, null, null, limit);
	}
	
	default List<BlvtSubscriptionRecord> querySubscriptionRecords(String tokenName){
		return querySubscriptionRecords(tokenName, null, null, null, null);
	}
	
	default List<BlvtSubscriptionRecord> querySubscriptionRecord(Integer limit){
		return querySubscriptionRecords(null, null, null, null, limit);
	}
	
	default List<BlvtSubscriptionRecord> querySubscriptionRecords(){
		return querySubscriptionRecords(null, null, null, null, null);
	}
	
	//Query Redemption Record (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/redeem/record",
			needSignature = true,
			parameters = {Parameters.tokenName, Parameters.id, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	default List<BlvtRedemptionRecord> queryRedemptionRecords(String tokenName, Long id, Long startTime, Long endTime, Integer limit) {
		if (limit != null)
			if (limit <= 0 || limit > 1000)
				throw new IllegalArgumentException("limit must be between 1 and 1000. limit=" + limit);
		return null;
	}
	
	default BlvtRedemptionRecord queryRedemptionRecord(long id) {
		try{
			return queryRedemptionRecords(null, id, null, null, null).get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	default List<BlvtRedemptionRecord> queryRedemptionRecords(String tokenName, Long startTime, Long endTime, Integer limit) {
		return queryRedemptionRecords(tokenName, null, startTime, endTime, limit);
	}
	
	default List<BlvtRedemptionRecord> queryRedemptionRecords(String tokenName, Integer limit) {
		return queryRedemptionRecords(tokenName, null, null, null, limit);
	}
	
	default List<BlvtRedemptionRecord> queryRedemptionRecords(String tokenName){
		return queryRedemptionRecords(tokenName, null, null, null, null);
	}
	
	default List<BlvtRedemptionRecord> queryRedemptionRecords(Integer limit){
		return queryRedemptionRecords(null, null, null, null, limit);
	}
	
	default List<BlvtRedemptionRecord> queryRedemptionRecords(){
		return queryRedemptionRecords(null, null, null, null, null);
	}
	
	//Get BLVT User Limit Info (USER_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/userLimit",
			needSignature = true
	)
	@JsonMap(key = "tokenName")
	public Map<String, BlvtUserLimitInfo> getBlvtUserLimitInfos();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/userLimit",
			needSignature = true,
			parameters = Parameters.tokenName,
			mandatory = true
	)
	public BlvtUserLimitInfo getBlvtUserLimitInfo(String tokenName);
}
