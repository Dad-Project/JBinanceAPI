package fr.rowlaxx.binanceapi.client.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BaseEndpointResolver {

	//Variables
	private HashMap<BaseEndpoints, BaseEndpoint> baseEndpoints;
	private List<BaseEndpoint> customBaseEndpoints;
	private BaseEndpoint def;
	
	//Constructeurs
	public BaseEndpointResolver() {
		this.baseEndpoints = new HashMap<>();
		this.customBaseEndpoints = new ArrayList<>();
		this.def = get(BaseEndpoints.SPOT);
	}
	
	//Methodes
	public BaseEndpoint get(BaseEndpoints be) {
		Objects.requireNonNull(be, "be may not be null.");
		
		if (baseEndpoints.containsKey(be))
			return baseEndpoints.get(be);
		
		final BaseEndpoint endpoint = new BaseEndpoint(be.getUrls());
		baseEndpoints.put(be, endpoint);
		return endpoint;
	}
	
	public BaseEndpoint get(String... urls) {
		for (BaseEndpoint endpoint : baseEndpoints.values() )
			if (endpoint.matches(urls))
				return endpoint;
		
		for (BaseEndpoint endpoint : customBaseEndpoints)
			if (endpoint.matches(urls))
				return endpoint;
		
		final BaseEndpoint endpoint = new BaseEndpoint(urls);
		customBaseEndpoints.add(endpoint);
		return endpoint;
	}
	
	public boolean contains(BaseEndpoint baseEndpoint) {
		if (baseEndpoints.containsValue(baseEndpoint))
			return true;
		if (customBaseEndpoints.contains(baseEndpoint))
			return true;
		return false;
	}
	
	public BaseEndpoint get(Collection<String> urls) {
		for (BaseEndpoint endpoint : baseEndpoints.values() )
			if (endpoint.matches(urls))
				return endpoint;
		
		for (BaseEndpoint endpoint : customBaseEndpoints)
			if (endpoint.matches(urls))
				return endpoint;
		
		final BaseEndpoint endpoint = new BaseEndpoint(urls);
		customBaseEndpoints.add(endpoint);
		return endpoint;
	}
	
	public BaseEndpoint getDefaultBaseEndpoint() {
		return def;
	}
	
	public void setDefaultBaseEndpoint(BaseEndpoint def) {
		this.def = def;
	}
}
