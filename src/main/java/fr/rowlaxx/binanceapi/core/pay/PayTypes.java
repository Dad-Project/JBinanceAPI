package fr.rowlaxx.binanceapi.core.pay;

public enum PayTypes {

	PAY, //(C2B Merchant Acquiring Payment), 
	PAY_REFUND, //(C2B Merchant Acquiring Payment,refund), 
	C2C, //(C2C Transfer Payment),
	CRYPTO_BOX, //(Crypto box), 
	CRYPTO_BOX_RF, //(Crypto Box, refund), 
	C2C_HOLDING, //(Transfer to new Binance user), 
	C2C_HOLDING_RF, //(Transfer to new Binance user,refund), 
	PAYOUT, //(B2C Disbursement Payment)
	
}
