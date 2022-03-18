package fr.rowlaxx.binanceapi.api.options;

public final class OptionsAPI {

	private final OptionsQuotingAPI quoting;
	private final OptionsTradeAPI trade;
	
	public OptionsAPI(OptionsQuotingAPI quoting, OptionsTradeAPI trade) {
		this.quoting = quoting;
		this.trade = trade;
	}
	
	public OptionsQuotingAPI quoting() {
		return quoting;
	}
	
	public OptionsTradeAPI trade() {
		return trade;
	}
}
