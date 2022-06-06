![Alt text](https://upload.wikimedia.org/wikipedia/commons/1/12/Binance_logo.svg)  

# JBinanceAPI
An easy to maintain java library that will cover all available Binance endpoints & streams  
JBinanceAPI uses reflection for sending requests (using a proxy) & parsing responses (using JSavON)  

Add this to your POM to add JBinanceAPI in your project :  
```xml
<repositories>
	<repository>
		<id>central</id>
		<name>Artifactory-releases</name>
		<url>http://box.dad-project.com:8081/artifactory/libs-release-local</url>
	</repository>
</repositories>
<dependencies>
	<dependency>
		<groupId>fr.rowlaxx</groupId>
		<artifactId>binanceapi</artifactId>
		<version>1.0.5</version>
	</dependency>
</dependencies>
```

Documentation of each endpoint can be found here :  
https://binance-docs.github.io/apidocs/#change-log

Please note that a lot of endpoints needs to be tested.
If you find a bug, please report it in the issues section

# Features

The version refers to the last date the API has been modified.  

Legend :  
✔️ - Implemented  
❌ - Not implemented  

All the ❌ fields will be implemented.

|                    | Spot | Margin | Usd-M | Coin-M | Options |
|:------------------:|:----:|:------:|:-----:|:------:|:-------:|
|       Trades       |  ✔️  |  ✔️  |  ✔️  |   ✔️  |   ✔️    |
|     Market Data    |  ✔️  |  ✔️  |  ✔️  |   ✔️  |   ✔️    |
|     User Stream    |  ✔️  |  ✔️  |  ❌  |   ❌  |   ❌    |
| Market Data Stream |  ✔️  |  ✔️  |  ❌  |   ❌  |   ❌    |
|       Version      | 2022-05-23 | 2022-05-26 | 2022-02-01 | 2022-02-01 | 2022-01-30 |

|             | Implemented |   Version  |
|:-----------:|:-----------:|:----------:|
|     BLVT    |     ✔️     | 2022-04-08 |
|    BSwap    |     ✔️     | 2022-01-30 |
|     C2C     |     ✔️     | 2022-01-30 |
|   Convert   |     ✔️     | 2022-01-30 |
| CryptoLoans |     ✔️     | 2022-01-30 |
|     Fiat    |     ✔️     | 2022-05-31 |
|   Futures   |     ✔️     | 2022-01-30 |
| Futures Algo|     ✔️     | 2022-04-27 |
|   Giftcard  |     ✔️     | 2022-05-05 |
|    Mining   |     ✔️     | 2022-05-19 |
|     NFT     |     ✔️     | 2022-01-30 |
|     Pay     |     ✔️     | 2022-05-31 |
|    Rebate   |     ✔️     | 2022-01-30 |
|   Savings   |     ✔️     | 2022-01-28 |
|   Staking   |     ✔️     | 2022-04-28 |
| Sub-Account |     ✔️     | 2022-03-29 |
|    Wallet   |     ✔️     | 2022-03-19 |

# Usage

## Creating a client

### As guest
```java
BinanceClient client = BinanceClient.createGuest();
```

### With Api Key & Api Secret

```java
BinanceCredenticals credenticals = new BinanceCredenticals(apiKey, apiSecret);
BinanceClient client = BinanceCient.create(credenticals);  
```
or 
 
```java
BinanceClient client = BinanceCLient.create(apiKey, apiSecret);
```

## Getting Candlesticks

```java
List<BasicCandlestick> candlesticks = client.spot().market().getCandlesticks("BTCUSDT", Intervals.HOUR_1, 1000);
```
For the last 1 000 hourly candlesticks

## Obtaining coin address

```java
String coin = "BTC";
String network = null;
DepositAddress address = client.wallet().getDepositAddress(coin, network);
```

## Placing an order

```java
SpotOrderRequest order = NewOrderRequest.spot()
        .setSymbol("BTCUSDT")
        .setSide(OrderSide.BUY)
        .setType(SpotOrderTypes.MARKET)
        .setQuantity(0.001)
        .build();

SpotOrder response = client.spot().trade().postOrder(order);
```

## Sending a custom request
```java
BinanceHttpRequest request = BinanceHttpRequest.newBuilder()
        .setEndpoint(...)
        .setBaseEndpoint(...)
        .//Customize your request
        .build()
  
//T can be JSONObject or a JSONArray
T response = client.getHttpClient().execute(request);
```
## Connecting to a web socket
Let's suppose we want to print each BTCUSDT trades using websockets.  

With interface implementation : 
```java
client.spot().marketstream().addOnTradeEvent(new OnTrade() {
	@Override
	public void onTrade(String symbol, SpotStreamTrade trade) {
		System.out.println(trade);
	}
});
```
Or, with lamba expressions :
```java		
client.spot().marketstream().addOnTradeEvent( (String symbol, SpotStreamTrade trade) -> System.out.println(trade) );
```

Then use
```java
client.spot().marketstream().subscribeTrade("btcusdt");
```

# Donation
As a student, any help will be appreciated

BTC : 1JJZrkZEynrCqoPrJWKbtGLSyJziDmKKka  
ETH : 0xe349abf167a8d265785b256666737ecd5720d4bd  
BNB : bnb136ns6lfw4zs5hg4n85vdthaad7hq5m4gtkgf23  
TAG : 107019672  
