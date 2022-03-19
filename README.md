![Alt text](https://upload.wikimedia.org/wikipedia/commons/1/12/Binance_logo.svg)  

# JBinanceAPI
An easy to maintain java library that will cover all available Binance endpoints & stream  
JBinanceAPI use reflection for sending request (using a proxy) & parsing responses (using JSavON)  

Documentation of each endpoint can be found here :  
https://binance-docs.github.io/apidocs/#change-log


Requiered libraries :  
- JSavON https://github.com/Dad-Project/Jsavon
- JSON-Java https://github.com/stleary/JSON-java
- Convert-Utils https://github.com/Dad-Project/Convert-Utils
- Reflection-Utils https://github.com/Dad-Project/Reflection-UtilsReflection-Utils

Please note that a lot of endpoints needs to be tested.
If you find a bug, please report it in the issues section

# Features

The version refer to the last date the API has been modified.  

Meaning of symbols :  
✔️ - Implemented  
❌ - Not implemented  

All the ❌ fields will be implemented.

|                    | Spot | Usd-M | Coin-M | Options |
|:------------------:|:----:|:-----:|:------:|:-------:|
|       Trades       |  ✔️  |  ✔️  |   ✔️  |   ✔️    |
|     Market Data    |  ✔️  |  ✔️  |   ✔️  |   ✔️    |
|     User Stream    |  ❌  |  ❌  |   ❌  |   ❌    |
| Market Data Stream |  ❌  |  ❌  |   ❌  |   ❌    |
|       Testnet      |      |  ❌  |   ❌  |          |

Currently implementing : Market Data Stream

|         |    Spot    |    Usd-M   |   Coin-M   |   Options  |
|:-------:|:----------:|:----------:|:----------:|:----------:|
| Version | 2022-01-30 | 2022-02-01 | 2022-02-01 | 2022-01-30 |

|             | Implemented |   Version  |
|:-----------:|:-----------:|:----------:|
|     BLVT    |     ✔️     | 2022-01-30 |
|    BSwap    |     ✔️     | 2022-01-30 |
|     C2C     |     ✔️     | 2022-01-30 |
|   Convert   |     ✔️     | 2022-01-30 |
| CryptoLoans |     ✔️     | 2022-01-30 |
|     Fiat    |     ✔️     | 2022-01-30 |
|   Futures   |     ✔️     | 2022-01-30 |
|   Giftcard  |     ✔️     | 2022-01-30 |
|    Margin   |     ✔️     | 2022-01-27 |
|    Mining   |     ✔️     | 2022-01-30 |
|     NFT     |     ✔️     | 2022-01-30 |
|     Pay     |     ✔️     | 2022-01-30 |
|    Rebate   |     ✔️     | 2022-01-30 |
|   Savings   |     ✔️     | 2022-01-28 |
| Sub-Account |     ✔️     | 2022-01-27 |
|    Wallet   |     ✔️     | 2022-01-26 |

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
### Login
 
```java
client.login(); //For testing your credenticals
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

## Getting Candlesticks

```java
List<BasicCandlestick> candlesticks = client.spot().market().getCandlesticks("BTCUSDT", Intervals.HOUR_1, 1000);
```
For the last 1 000 hourly candlesticks

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
# Donation
As a student, any help will be appreciated

BTC : 1JJZrkZEynrCqoPrJWKbtGLSyJziDmKKka  
ETH : 0xe349abf167a8d265785b256666737ecd5720d4bd  
BNB : bnb136ns6lfw4zs5hg4n85vdthaad7hq5m4gtkgf23  
TAG : 107019672  
