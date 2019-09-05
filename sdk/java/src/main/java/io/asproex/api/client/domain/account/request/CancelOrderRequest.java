package io.asproex.api.client.domain.account.request;

import io.asproex.api.client.constant.AsproexConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Request object for canceling an order.
 */
public class CancelOrderRequest extends OrderRequest {

    private Long orderId;

    private String clientOrderId;

    public CancelOrderRequest(Long orderId) {
        super();
        this.orderId = orderId;
    }

    public CancelOrderRequest(String clientOrderId) {
        super();
        this.clientOrderId = clientOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public CancelOrderRequest orderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public CancelOrderRequest clientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, AsproexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .toString();
    }
}
