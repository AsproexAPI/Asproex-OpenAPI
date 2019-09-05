package io.Asproex.api.test;

import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexApiWebSocketClient;
import io.asproex.api.client.domain.market.CandlestickInterval;



public class MarketDataStreamTest {

    public static void main(String[] args) {

       AsproexApiWebSocketClient client = AsproexApiClientFactory.newInstance().newWebSocketClient();

        // depth
        client.onDepthEvent("BTCUSDT", response -> System.out.println(response));

        // kline
        client.onCandlestickEvent("BTCUSDT", CandlestickInterval.ONE_MINUTE, response -> System.out.println(response));

        // trades
        client.onTradeEvent("BTCUSDT", response -> System.out.println(response));

        // ticker for 24 hour
        client.onTicker24HourEvent("BTCUSDT", response -> System.out.println(response));

        // index
        client.onIndexEvent("BTCUSDT", System.out::println);
    }
}
