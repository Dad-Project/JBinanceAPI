package fr.rowlaxx.binanceapi.core.futures.marketdata;

public enum ContractTypes {
	
    PERPETUAL,
    CURRENT_QUARTER,
    CURRENT_QUARTER_DELIVERING, // Invalid type, only used for DELIVERING status
    CURRENT_MONTH,
    NEXT_QUARTER,
    NEXT_QUARTER_DELIVERING, // Invalid type, only used for DELIVERING status
    NEXT_MONTH,

}
