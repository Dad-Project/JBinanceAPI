package fr.rowlaxx.binanceapi.core.general.options;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.ExchangeInformation;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

public class OptionExchangeInformation extends ExchangeInformation<OptionSymbol> {
	private static final long serialVersionUID = 8537806609654238210L;

	//Variables
	@JOValue(key = "optionSymbols", path = "/data/")
	@MapKey(fieldName = "symbol")
	private Map<String, OptionSymbol> symbols;
	
	@JOValue (path = "/data/")
	private List<OptionContract> optionContracts;
	@JOValue (path = "/data/")
	private List<OptionAsset> optionAssets;
	
	//Constructeurs
	public OptionExchangeInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	@Override
	public Map<String, OptionSymbol> getSymbols() {
		return symbols;
	}
	
	public List<OptionAsset> getOptionAssets() {
		return optionAssets;
	}
	
	public List<OptionContract> getOptionContracts() {
		return optionContracts;
	}
}
