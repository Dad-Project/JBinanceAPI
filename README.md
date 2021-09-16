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
