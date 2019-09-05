package io.Asproex.api.test;


import io.aspoex.api.test.constant.Constants;
import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexApiRestClient;
import io.asproex.api.client.constant.AsproexConstants;
import io.asproex.api.client.domain.account.Account;
import io.asproex.api.client.domain.account.CancelOrderResponse;
import io.asproex.api.client.domain.account.DepositOrder;
import io.asproex.api.client.domain.account.NewOrder;
import io.asproex.api.client.domain.account.NewOrderResponse;
import io.asproex.api.client.domain.account.Order;
import io.asproex.api.client.domain.account.TimeInForce;
import io.asproex.api.client.domain.account.Trade;
import io.asproex.api.client.domain.account.request.CancelOrderRequest;
import io.asproex.api.client.domain.account.request.DepositOrderRequest;
import io.asproex.api.client.domain.account.request.HistoryOrderRequest;
import io.asproex.api.client.domain.account.request.MyTradeRequest;
import io.asproex.api.client.domain.account.request.OpenOrderRequest;
import io.asproex.api.client.domain.account.request.OrderStatusRequest;

import java.util.List;

public class AccountRestApiTest {


    public static void main(String[] args) {

        AsproexApiClientFactory factory = AsproexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        AsproexApiRestClient client = factory.newRestClient();

        System.out.println("\n ------limit buy-----");
        NewOrderResponse response1 = client.newOrder(NewOrder.limitBuy("BTCUSDT", TimeInForce.GTC, "0.01", "5678.9"));
        System.out.println(response1);
//
        System.out.println("\n ------limit sell-----");
        NewOrderResponse response2 = client.newOrder(NewOrder.limitSell("BTCUSDT", TimeInForce.GTC, "0.01", "1001"));
        System.out.println(response2);

        System.out.println("\n ------market buy-----");
        NewOrderResponse response3 = client.newOrder(NewOrder.marketBuy("BTCUSDT", "10"));
        System.out.println(response3);

        System.out.println("\n ------market sell-----");
        NewOrderResponse response4 = client.newOrder(NewOrder.marketSell("BTCUSDT", "0.01"));
        System.out.println(response4);

        System.out.println("\n ------get order status-----");
        Order order = client.getOrderStatus(new OrderStatusRequest(response1.getOrderId()));
        System.out.println(order);

        System.out.println("\n ------cancel order-----");
        CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(response1.getOrderId()));
        System.out.println(cancelOrderResponse);

        System.out.println("\n ------get open orders-----");
        List<Order> openOrderList = client.getOpenOrders(new OpenOrderRequest("BTCUSDT", 5));
        System.out.println(openOrderList);
//
        System.out.println("\n ------get history orders-----");
        List<Order> historyOrderList = client.getHistoryOrders(new HistoryOrderRequest());
        System.out.println(historyOrderList);

        System.out.println("\n ------get account information-----");
        Account account = client.getAccount(AsproexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(account);
        System.out.println(account.getBalances());
        System.out.println(account.getAssetBalance("ETH"));

        System.out.println("\n ------get trades -----");
        List<Trade> tradeList = client.getMyTrades(new MyTradeRequest(5));
        System.out.println(tradeList);

        System.out.println("\n ------get deposit order -----");
        List<DepositOrder> list = client.getDepositOrders(new DepositOrderRequest());
        System.out.println(list);

    }

}
