package io.asproex.api.client.impl;

import java.util.List;

import io.asproex.api.client.AsproexOptionApiRestClient;
import io.asproex.api.client.constant.AsproexConstants;
import io.asproex.api.client.domain.account.request.CancelOrderRequest;
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
import io.asproex.api.client.service.AsproexOptionApiService;
import static io.asproex.api.client.impl.AsproexApiServiceGenerator.createService;
import static io.asproex.api.client.impl.AsproexApiServiceGenerator.executeSync;

/**
 * Implementation of Asproex's Option REST API using Retrofit with synchronous/blocking method calls.
 */
public class AsproexOptionApiRestClientImpl implements AsproexOptionApiRestClient {

    private final AsproexOptionApiService asproseOptionApiService;

    public AsproexOptionApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        asproseOptionApiService = createService(baseUrl, AsproexOptionApiService.class, apiKey, secret);
    }

    @Override
    public List<TokenOptionResult> getOptions(OptionsRequest request) {
        return executeSync(asproseOptionApiService.getOptions(request.getExpired()));
    }

    @Override
    public OptionOrderResult newOptionOrder(OptionOrderRequest request) {
        return executeSync(asproseOptionApiService.newOptionOrder(
                request.getSymbol(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getOrderType() == null ? "" : request.getOrderType().name(),
                request.getTimeInForce().name(),
                request.getQuantity(),
                request.getPrice(),
                request.getClientOrderId(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public OptionOrderResult cancelOptionOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(asproseOptionApiService.cancelOptionOrder(
                cancelOrderRequest.getOrderId(),
                cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(),
                cancelOrderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionOpenOrders(OptionOpenOrderRequest orderRequest) {
        return executeSync(asproseOptionApiService.getOptionOpenOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getLimit(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionHistoryOrders(OptionHistoryOrderRequest orderRequest) {
        return executeSync(asproseOptionApiService.getOptionHistoryOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit(),
                orderRequest.getOrderStatus() == null ? "" : orderRequest.getOrderStatus().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionMatchResult> getOptionMyTrades(OptionTradeRequest request) {
        return executeSync(asproseOptionApiService.getOptionMyTrades(
                request.getSymbol(),
                request.getFromId(),
                request.getToId(),
                request.getLimit(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<PositionResult> getOptionPositions(OptionPositionRequest request) {
        return executeSync(asproseOptionApiService.getOptionPositions(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<SettlementResult> getOptionSettlements(OptionSettlementRequest request) {
        return executeSync(asproseOptionApiService.getOptionSettlements(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }
}
