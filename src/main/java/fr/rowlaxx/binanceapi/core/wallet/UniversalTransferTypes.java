package fr.rowlaxx.binanceapi.core.wallet;

public enum UniversalTransferTypes {


    MAIN_C2C, //Spot account transfer to C2C account
    MAIN_UMFUTURE, //Spot account transfer to USDⓈ-M Futures account
    MAIN_CMFUTURE, //Spot account transfer to COIN-M Futures account
    MAIN_MARGIN, //Spot account transfer to Margin（cross）account
    MAIN_MINING, //Spot account transfer to Mining account
    C2C_MAIN, //C2C account transfer to Spot account
    C2C_UMFUTURE, //C2C account transfer to USDⓈ-M Futures account
    C2C_MINING, //C2C account transfer to Mining account
    C2C_MARGIN, //C2C account transfer to Margin(cross) account
    UMFUTURE_MAIN, //USDⓈ-M Futures account transfer to Spot account
    UMFUTURE_C2C, //USDⓈ-M Futures account transfer to C2C account
    UMFUTURE_MARGIN, //USDⓈ-M Futures account transfer to Margin（cross）account
    CMFUTURE_MAIN, //COIN-M Futures account transfer to Spot account
    CMFUTURE_MARGIN, //COIN-M Futures account transfer to Margin(cross) account
    MARGIN_MAIN, //Margin（cross）account transfer to Spot account
    MARGIN_UMFUTURE, //Margin（cross）account transfer to USDⓈ-M Futures
    MARGIN_CMFUTURE, //Margin（cross）account transfer to COIN-M Futures
    MARGIN_MINING, //Margin（cross）account transfer to Mining account
    MARGIN_C2C, //Margin（cross）account transfer to C2C account
    MINING_MAIN, //Mining account transfer to Spot account
    MINING_UMFUTURE, //Mining account transfer to USDⓈ-M Futures account
    MINING_C2C, //Mining account transfer to C2C account
    MINING_MARGIN, //Mining account transfer to Margin(cross) account
    MAIN_PAY, //Spot account transfer to Pay account
    PAY_MAIN, //Pay account transfer to Spot account
    ISOLATEDMARGIN_MARGIN, //Isolated margin account transfer to Margin(cross) account
    MARGIN_ISOLATEDMARGIN, //Margin(cross) account transfer to Isolated margin account
    ISOLATEDMARGIN_ISOLATEDMARGIN, //Isolated margin account transfer to Isolated margin account
	
}
