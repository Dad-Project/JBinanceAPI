# JBinanceAPI
A simple Binance Java API that use reflection for sending request & for converting JSON into object

## Creating a client

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

## Implemented features

* BLVT
* C2C
* Fiat
* Spot (Wallet)
* Spot (Market)
* Master & Sub Account
* Futures

## Unimplemented features (will be implemented soon)

* Spot (Trade)
* Futures USD Margined
* Futures Coin Margined
* Options
* Minings
* Savings
* Margin
* Websockets

## Sending a custom request
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
