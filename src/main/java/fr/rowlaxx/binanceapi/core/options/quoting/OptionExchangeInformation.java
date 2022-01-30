package fr.rowlaxx.binanceapi.core.options.quoting;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.SimpleExchangeInformation;
import fr.rowlaxx.jsavon.annotations.MapKey;

public class OptionExchangeInformation extends SimpleExchangeInformation<OptionSymbol> {
	private static final long serialVersionUID = 8537806609654238210L;

	//Variables
	@MapKey(fieldName = "symbol")
	private Map<String, OptionSymbol> optionSymbols;
	
	private List<OptionContract> optionContracts;
	private List<OptionAsset> optionAssets;
	
	//Constructeurs
	public OptionExchangeInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	@Override
	public final Map<String, OptionSymbol> getSymbols() {
		return optionSymbols;
	}
	
	public final List<OptionAsset> getOptionAssets() {
		return optionAssets;
	}
	
	public final List<OptionContract> getOptionContracts() {
		return optionContracts;
	}
}
