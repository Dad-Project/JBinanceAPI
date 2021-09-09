package fr.rowlaxx.binanceapi.core.general;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filters.Type;
import fr.rowlaxx.binanceapi.exceptions.FilterInstanciationException;
import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class Filter extends JSavONObject {
	private static final long serialVersionUID = -2095714718119354586L;

	//Statique
	@SuppressWarnings("unchecked")
	public static <T extends Filter> T fromJson(JSONObject json) {
		final Filters filters = Filters.valueOf( json.getString("filterType") );
		final Class<T> clazz = (Class<T>) filters.getTypeClass();
		try {
			return clazz.getConstructor(JSONObject.class).newInstance(json);
		} catch (Exception e) {
			throw new FilterInstanciationException(e);
		} 
	}

	//Variables
	@JOValue private Filters filterType;

	//Constructeurs
	protected Filter(JSONObject response) {
		super(response);
	}

	//Getters
	public Filters getFilterType() {
		return filterType;
	}

	public boolean isSymbolFilter() {
		return filterType.getType() == Type.SYMBOL;
	}

	public boolean isExchangeFilter() {
		return filterType.getType() == Type.EXCHANGE;
	}
}