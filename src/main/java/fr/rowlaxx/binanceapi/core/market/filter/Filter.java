package fr.rowlaxx.binanceapi.core.market.filter;

import java.lang.reflect.Constructor;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exception.BinanceException;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class Filter extends BinanceResponseJSON {
	private static final long serialVersionUID = -2095714718119354586L;

	//Statique
	@SuppressWarnings("unchecked")
	public static <T extends Filter> T fromJson(JSONObject json) {
		final Filters filters = Filters.valueOf( json.getString("filterType") );
		final Class<T> clazz = (Class<T>) filters.getTypeClass();
		try{
			final Constructor<T> constructor = clazz.getConstructor(JSONObject.class);
			return constructor.newInstance(json);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BinanceException("Unable to parse the filter." + e);
		} 
	}
	
	//Variables
	@JsonValue private Filters filterType;

	//Constructeurs
	Filter(JSONObject response) {
		super(response);
	}

	//Getters
	public Filters getFilterType() {
		return filterType;
	}
}