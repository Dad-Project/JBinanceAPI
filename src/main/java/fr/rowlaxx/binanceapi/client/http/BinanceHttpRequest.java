package fr.rowlaxx.binanceapi.client.http;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import fr.rowlaxx.binanceapi.utils.ConvertUtils;

public class BinanceHttpRequest {

	//Methodes statiques
	public static Builder newBuilder(String endpoint, Method method) {
		return new Builder(endpoint, method);
	}
	
	public static Builder newBuilder() {
		return new Builder();
	}

	//Builder
	public static class Builder{

		//Variables
		private BinanceHttpRequest request;

		//Constructeurs
		public Builder(String endpoint, Method method) {
			this();
			setEndpoint(endpoint);
			setMethod(method);
		}
		
		public Builder() {
			this.request = new BinanceHttpRequest();
		}

		//Methodes statiques
		private static String check(String s) {
			if ( s == null)
				throw new NullPointerException("null string.");
			if (s.isEmpty())
				throw new IllegalArgumentException("empty string.");
			if ( !s.matches("[\\w]*") )
				throw new IllegalArgumentException("Invalid string : " + s);
			return s;
		}
		
		//Setters
		public Builder removeParameters(Parameters param) {
			request.parameters.remove(param);
			return this;
		}
		
		public Builder addParameter(Parameters param, Object value) {
			Objects.requireNonNull(param, "param may not be null.");
			if (param == Parameters.timestamp || param == Parameters.recvWindow)
				throw new IllegalArgumentException("param cannot be timestamp or recvWindow");
			if (value == null)
				return this;
			if (!param.canBeAssignedWith(value))
				throw new IllegalArgumentException("param \"" + param + "\" cannot be assigned with " + value.getClass() );
			
			request.parameters.putIfAbsent(param, new HashSet<>());
			final Set<String> values = request.parameters.get(param);
			
			if (value instanceof Number)
				values.add(ConvertUtils.convertToString((Number) value));
			else
				values.add( check(value.toString()) );
					
			return this;
		}
		
		public Builder setParameter(Parameters param, Object value) {
			removeParameters(param);
			return addParameter(param, value);
		}
		
		public Builder addParameters(Parameters param, Object[] values) {
			for (Object value : values)
				addParameter(param, value);
			return this;
		}
		
		public Builder setParameters(Parameters param, Object[] values) {
			removeParameters(param);
			return addParameters(param, values);
		}
		
		public Builder addParameters(Parameters param, Collection<?> values) {
			for (Object value : values)
				addParameter(param, value);
			return this;
		}
		
		public Builder setParameters(Parameters param, Collection<?> values) {
			removeParameters(param);
			return addParameters(param, values);
		}
		
		public Builder setBaseEndpoint(String baseEndpoint) {
			request.baseEndpoint = baseEndpoint;
			return this;
		}
		
		public Builder setEndpoint(String endpoint) { 
			request.endpoint = Objects.requireNonNull(endpoint, "endpoint may not be null.");;
			return this;
		}
		
		public Builder setMethod(Method method) {
			request.method = Objects.requireNonNull(method, "method may not be null.");
			return this;
		}
		
		public Builder setRecvWindow(Long recvWindow) {
			if (recvWindow == null)
				request.recvWindow = null;
			else if (recvWindow <= 0 || recvWindow > 60000)
				throw new IllegalArgumentException("recvWindow must be between 1 and 60000.");
			else
				request.recvWindow = recvWindow;
			return this;
		}
		
		public Builder addSignature(boolean addSignature) {
			request.addSignature = addSignature;
			return this;
		}

		public BinanceHttpRequest build() {
			try{
				if (request.method == null)
					throw new IllegalStateException("method is null.");
				if (request.endpoint == null)
					throw new IllegalStateException("endpoint is null.");
				return request;
			}finally {
				this.request = null;
			}
		}
	}

	//Enum
	public static enum Method{GET,POST,DELETE}

	//Variables
	private Long recvWindow = null;
	private String baseEndpoint = null;
	private String endpoint = null;
	private boolean addSignature = true;
	private Method method = null;

	private final HashMap<Parameters, Set<String>> parameters = new HashMap<>();

	//Getters
	public final String getEndpoint() {
		return endpoint;
	}

	public final String getBaseEndpoint() {
		return baseEndpoint;
	}
	
	public final boolean hasRecvWindow() {
		return recvWindow != null;
	}
	
	public final boolean hasBaseEndpoint() {
		return baseEndpoint != null;
	}
	
	public final Long getRecvWindow() {
		return recvWindow;
	}
	
	public final Method getMethod() {
		return method;
	}

	public final String getParameter(Parameters param) {
		final Set<String> values = parameters.get(param);
		if (values == null)
			return null;
		if (values.size() != 1)
			throw new BinanceHttpRequestException("There are multiple value with this parameter. Please use getParameters method.");
		return (String) values.toArray()[0];
	}
	
	public final Set<String> getParameters(Parameters name){
		return Collections.unmodifiableSet(parameters.get(name));
	}
	
	public final Map<Parameters, Set<String>> getParameters() {
		final Map<Parameters, Set<String>> parameters = new HashMap<Parameters, Set<String>>();
		for (Parameters param : this.parameters.keySet() )
			parameters.put(param, getParameters(param));
		return Collections.unmodifiableMap(parameters);
	}
	
	public final boolean addSignature() {
		return addSignature;
	}
}
