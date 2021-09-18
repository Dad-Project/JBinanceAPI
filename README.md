# JBinanceAPI
A complete Binance Java API that use reflection for sending request & for converting JSON into object with JSavON.  
Please note that this library is still in early stage and a lot of endpoints needs to be tested.
If you find a bug, please report it in the issues section (I will fix it in a short amount of time)

Also, if you like this library, consider donating me a few bucks. It will help me a lot.

Requiered library : 
JSavON          https://github.com/RowlaxX/JSavON

# Implemented features

* BLVT
* C2C
* Fiat
* Spot (Wallet)
* Spot (Market)
* Master & Sub Account
* Futures

# Unimplemented features (will be implemented soon)

* Spot (Trade)
* Futures USD Margined
* Futures Coin Margined
* Options
* Minings
* Savings
* Margin (Currently implementing)
* Websockets

# Creating a client

### Guest
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
        .build()

SpotOrder response = client.spot().postOrder(order);
```

# Getting Candlesticks

```java
List<BasicCandlestick> candlesticks = client.spot().getCandlesticks("BTCUSDT", Intervals.HOUR_1, 1000);
```
For the last 1000 hourly candlesticks

# Sending a custom request (for unimplemented endpoints)
```java
BinanceHttpRequest request = BinanceHttpRequest.newBuilder()
        .setEndpoint(...)
        .setBaseEndpoint(...)
        .//Customize your request
        .build()
  
//T can be a JSONObject or a JSONArray
T response = client.getHttpClient().execute(request);
  
//Parse the json
```
# Donation
I'm a student, so any help will be appreciated
### For gentleman
BTC : 1JJZrkZEynrCqoPrJWKbtGLSyJziDmKKka
### For optimistics
ETH : 0xe349abf167a8d265785b256666737ecd5720d4bd
### BNB Love
BNB : bnb136ns6lfw4zs5hg4n85vdthaad7hq5m4gtkgf23  
TAG : 107019672
### Some XRP ?
XRP : rEb8TK3gBgk5auZkwc6sHnwrGVJH8DuaLh  
TAG : 109836101
### Maybe you prefer ADA ?
ADA : DdzFFzCqrht7QmsyECRJsZiM3neGxrGFjhrkDHjCnjT1w45oeVeNKf1KwBQWcVcPCcAuz7kfzbMhTG8BEpgX7FRy25XdTsk4RfM6YXqC
