package fr.rowlaxx.binanceapi.client.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class BaseEndpoint {

	//Variables
	private final List<String> baseEndpoints = new ArrayList<>();
	private int index = 0;
	
	//Constructeurs
	public BaseEndpoint(String... baseEndpoints) {
		Objects.requireNonNull(baseEndpoints);
		if (baseEndpoints.length == 0)
			throw new IllegalArgumentException("baseEndpoints cannot have a length of 0.");
		
		for (String s : baseEndpoints)
			addMirror(s);
	}
	
	public BaseEndpoint(Collection<String> baseEndpoints) {
		Objects.requireNonNull(baseEndpoints);
		if (baseEndpoints.size() == 0)
			throw new IllegalArgumentException("baseEndpoints cannot have a size of 0.");
		
		for (String s : baseEndpoints)
			addMirror(s);
	}
	
	//Methodes
	private void addMirror(String url) {
		if (!url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
			throw new IllegalArgumentException(url + " is not an url.");
		if (!this.baseEndpoints.contains(url))				
			this.baseEndpoints.add(url);
	}
	
	public boolean contains(String url) {
		return baseEndpoints.contains(url);
	}
	
	public String next() {
		index++;
		if (index >= baseEndpoints.size())
			index = 0;
		return baseEndpoints.get(index);
	}
	
	public int mirrorCount() {
		return baseEndpoints.size();
	}
	
	public boolean matches(String[] urls) {
		if (urls == null)
			return false;
		if (urls.length < baseEndpoints.size())
			return false;
		
		for (String s : urls)
			if (!contains(s))
				return false;
		
		return true;
	}
	
	public boolean matches(Collection<String> urls) {
		if (urls == null)
			return false;
		if (urls.size() < baseEndpoints.size())
			return false;
		
		for (String s : urls)
			if (!contains(s))
				return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseEndpoints == null) ? 0 : baseEndpoints.hashCode());
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEndpoint other = (BaseEndpoint) obj;
		if (baseEndpoints == null) {
			if (other.baseEndpoints != null)
				return false;
		} else if (!baseEndpoints.equals(other.baseEndpoints))
			return false;
		if (index != other.index)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return baseEndpoints.get(index);
	}
}