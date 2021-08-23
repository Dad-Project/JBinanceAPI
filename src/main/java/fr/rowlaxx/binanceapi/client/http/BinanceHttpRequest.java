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

		//Setters
		public Builder removeParameters(Parameters param) {
			request.parameters.remove(param);
			return this;
		}
		
		public Builder removeParameter(Parameters param, Object value) {
			request.parameters.remove(param, value);
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
			
			Set<Object> set;
			if (!request.parameters.containsKey(param)) {
				set = new HashSet<>();
				request.parameters.put(param, set);
			}
			else
				set = request.parameters.get(param);
			
			set.add(value);
			return this;
		}
		
		public Builder setParameter(Parameters param, Object value) {
			removeParameters(param);
			return addParameter(param, value);
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

	private final HashMap<Parameters, Set<Object>> parameters = new HashMap<>();

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
	
	public final String getTextParameters(Parameters name) {
		final Set<Object> values = parameters.get(name);
		if (values == null)
			return null;
		
		final StringBuilder sb = new StringBuilder();
		for (Object value : values) {
			if (sb.length() != 0)
				sb.append('&');
			
			sb.append(name.name());
			sb.append('=');
			
			if (value instanceof Collection<?>) {
				sb.append('[');
				for (Object obj : (Collection<?>)value ) {
					append(sb, obj);
					sb.append(',');
				}
				sb.setCharAt(sb.length()-1, ']');
			}
			else if (value.getClass().isArray()) {
				sb.append('[');
				for (Object obj : (Object[])value ) {
					sb.append('"');
					append(sb, obj);
					sb.append('"');
					sb.append(',');
				}
				sb.setCharAt(sb.length()-1, ']');
			}
			else
				append(sb, value);
		}
		
		return sb.toString();
	}
	
	private final static void append(StringBuilder sb, Object value) {
		if (value instanceof Number)
			sb.append( ConvertUtils.convertToString( (Number) value) );
		else
			sb.append(value.toString());
	}
	
	public final Set<Object> getParameters(Parameters name){
		return Collections.unmodifiableSet(parameters.get(name));
	}
	
	public final Map<Parameters, Set<Object>> getParameters() {
		final Map<Parameters, Set<Object>> parameters = new HashMap<Parameters, Set<Object>>();
		for (Parameters param : this.parameters.keySet() )
			parameters.put(param, getParameters(param));
		return Collections.unmodifiableMap(parameters);
	}
	
	public final boolean addSignature() {
		return addSignature;
	}
}
