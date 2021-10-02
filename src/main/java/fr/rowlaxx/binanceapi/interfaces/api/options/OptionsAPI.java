package fr.rowlaxx.binanceapi.interfaces.api.options;

public interface OptionsAPI extends OptionsQuotingInterfaces, OptionsAccountAndTrading {

	default OptionsQuotingInterfaces getOptionsQuotingInterfaces() {
		return this;
	}
	
	default OptionsAccountAndTrading getOptionsAccountAndTrading() {
		return this;
	}
	
}
