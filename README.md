# JBinanceAPI
A java library that try to cover all Binance endpoints available  

Documentation of each endpoint can be found here :  
https://binance-docs.github.io/apidocs/#change-log

JBinanceAPI use reflection for sending request & parsing responses with JSavon

Requiered libraries :  
- JSavON https://github.com/RowlaxX/JSavON
- JSON-Java https://github.com/stleary/JSON-java
- Convert-Utils https://github.com/RowlaxX/Convert-Utils
- Reflection-Utils https://github.com/RowlaxX/Reflection-Utils

Please note that a lot of endpoints needs to be tested.
If you find a bug, please report it in the issues section

## Spot features

Last update in parentheses

* BLVT <font size="1">(2022-01-30)</font>
* BSwap <font size="1">(2022-01-30)</font>
* C2C <font size="1">(2022-01-30)</font>
* Convert <font size="1">(2022-01-30)</font>
* CryptoLoans <font size="1">(2022-01-30)</font>
* Fiat <font size="1">(2022-01-30)</font>
* Futures <font size="1">(2022-01-30)</font>
* Giftcard <font size="1">(2022-01-30)</font>
* Margin <font size="1">(2022-01-27)</font>
* Market Data <font size="1">(2022-01-27)</font>
* Mining <font size="1">(2022-01-30)</font>
* NFT <font size="1">(2022-01-30)</font>
* Pay <font size="1">(2022-01-30)</font>
* Rebate <font size="1">(2022-01-30)</font>
* Savings <font size="1">(2022-01-28)</font>
* Sub Account <font size="1">(2022-01-27)</font>
* Trade <font size="1">(2022-01-27)</font>
* Wallet <font size="1">(2022-01-26)</font>

## Spot unimplemented features (will be implemented soon)

* User streams
* Market Data streams

## USD-M unimplemented features (will be implemented soon)

* Market Data
* Trade
* Market Data streams
* User streams
* Testnet

## COIN-M unimplemented features (will be implemented soon)

* Market Data
* Trade
* Market Data streams
* User streams
* Testnet

## Options features

* Quoting <font size="1">(2022-01-30)</font>
* Trade <font size="1">(Implementing...)</font>

## Options unimplemented features (will be implemented soon)

* Trade
* Account streams
* Market Data streams


# Creating a client

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
then use 
 
```java
client.login(); //For testing your credenticals
```
# Placing an order

```java
SpotOrderRequest order = NewOrderRequest.spot()
        .setSymbol("BTCUSDT")
        .setSide(OrderSide.BUY)
        .setType(SpotOrderTypes.MARKET)
        .setQuantity(0.001)
        .build();

SpotOrder response = client.spot().trade().postOrder(order);
```

# Getting Candlesticks

```java
List<BasicCandlestick> candlesticks = client.spot().market().getCandlesticks("BTCUSDT", Intervals.HOUR_1, 1000);
```
For the last 1000 hourly candlesticks

# Sending a custom request
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
