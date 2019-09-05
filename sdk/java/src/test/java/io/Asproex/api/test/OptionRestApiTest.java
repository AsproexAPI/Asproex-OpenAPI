package io.Asproex.api.test;



import io.aspoex.api.test.constant.Constants;
import io.asproex.api.client.AsproexApiClientFactory;
import io.asproex.api.client.AsproexOptionApiRestClient;
import io.asproex.api.client.domain.account.OrderSide;
import io.asproex.api.client.domain.account.OrderType;
import io.asproex.api.client.domain.account.TimeInForce;
import io.asproex.api.client.domain.option.OptionMatchResult;
import io.asproex.api.client.domain.option.OptionOrderResult;
import io.asproex.api.client.domain.option.PositionResult;
import io.asproex.api.client.domain.option.SettlementResult;
import io.asproex.api.client.domain.option.TokenOptionResult;
import io.asproex.api.client.domain.option.request.OptionHistoryOrderRequest;
import io.asproex.api.client.domain.option.request.OptionOpenOrderRequest;
import io.asproex.api.client.domain.option.request.OptionOrderRequest;
import io.asproex.api.client.domain.option.request.OptionPositionRequest;
import io.asproex.api.client.domain.option.request.OptionSettlementRequest;
import io.asproex.api.client.domain.option.request.OptionTradeRequest;
import io.asproex.api.client.domain.option.request.OptionsRequest;

import java.util.Date;
import java.util.List;

public class OptionRestApiTest {

    public static void main(String[] args) {
        AsproexApiClientFactory factory = AsproexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        AsproexOptionApiRestClient client = factory.newOptionRestClient();

        System.out.println("\n ------get options-----");

        List<TokenOptionResult> results
                = client.getOptions(OptionsRequest.builder().expired(Boolean.FALSE).build());

        System.out.println(results);

        System.out.println("\n ------new option order-----");
        OptionOrderResult optionOrderResult =
                client.newOptionOrder(OptionOrderRequest
                        .builder()
                        .symbol("BTC0226CS4000")
                        .price("10000")
                        .quantity("1")
                        .orderSide(OrderSide.BUY)
                        .orderType(OrderType.MARKET)
                        .clientOrderId(String.valueOf(new Date().getTime()))
                        .timeInForce(TimeInForce.GTC)
                        .timestamp(new Date().getTime())
                        .recvWindow(5_000L)
                        .build());
        System.out.println(optionOrderResult);
//
        System.out.println("\n ------new option order-----");
        List<PositionResult> positionResults
                = client.getOptionPositions(OptionPositionRequest
                .builder()
                .timestamp(new Date().getTime())
                .recvWindow(5_000L)
                .build());
        System.out.println(positionResults);

        System.out.println("\n ------new option settlement-----");
        List<SettlementResult> settlementResults
                = client.getOptionSettlements(OptionSettlementRequest.builder().timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(settlementResults);


        System.out.println("\n ------new option historyOrders-----");
        List<OptionOrderResult> optionOrderResults
                = client.getOptionHistoryOrders(OptionHistoryOrderRequest.builder().limit(10).timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionOrderResults);


        System.out.println("\n ------new option openOrders-----");
        List<OptionOrderResult> optionOpenOrders
                = client.getOptionOpenOrders(OptionOpenOrderRequest.builder().timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionOpenOrders);


        System.out.println("\n ------new option myTrades-----");
        List<OptionMatchResult> optionMatchResults
                = client.getOptionMyTrades(OptionTradeRequest.builder().symbol("BTC0226CS4000").timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionMatchResults);
    }
}
