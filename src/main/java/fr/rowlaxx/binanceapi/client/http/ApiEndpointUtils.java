package fr.rowlaxx.binanceapi.client.http;

import java.util.HashSet;
import java.util.Objects;

import fr.rowlaxx.binanceapi.exceptions.ApiEndpointException;

public class ApiEndpointUtils {
	
	public final static void verify(ApiEndpoint endpoint) {
		//Préliminaires
		Objects.requireNonNull(endpoint, "endpoint may not be null.");
		
		//On vérifie les endpoints
		if (endpoint.baseEndpoint() == BaseEndpoints.CUSTOM && endpoint.customBaseEndpoint().length == 0)
			throw new ApiEndpointException("you must precise at least one custom base endpoint.");
		
		//On vérifie la taille des tableaux
		if (endpoint.parameters().length != endpoint.mandatory().length)
			throw new ApiEndpointException("parameters and mandatory do not have the same size.");

		//On vérifie qu'il n'y a pas de doublon.
		final HashSet<Parameters> set = new HashSet<>();
		for (Parameters parameter : endpoint.parameters()) {
			Objects.requireNonNull(parameter, "a null parameter has been found.");
			if (!set.add(parameter))
				throw new ApiEndpointException("A duplicated parameters has been found in the endpoint.");
		}
	}

}
