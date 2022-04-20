package fr.rowlaxx.binanceapi.api.spot;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.core.portfoliomargin.PortfolioMargin;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

/**
 * @version 2022-04-20
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#portfolio-margin-endpoints
 */
public interface PortfolioMarginApi extends Api.Https, Api.Spot {

	//Get Portfolio Margin Account Info (USER_DATA)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = "sapi/v1/portfolio/account",
			method = Method.GET,
			parameters = {},
			mandatory = {}			
	)
	public PortfolioMargin getPortfolio();
	
}
