package io.asproex.api.client.domain.account.request;

import io.asproex.api.client.constant.AsproexConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A specialized order request with additional filters.
 */
public class OrderStatusRequest extends OrderRequest {

    private Long orderId;

    private String origClientOrderId;

    public OrderStatusRequest(Long orderId) {
        super();
        this.orderId = orderId;
    }

    public OrderStatusRequest(String origClientOrderId) {
        super();
        this.origClientOrderId = origClientOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderStatusRequest orderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public OrderStatusRequest origClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, AsproexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("origClientOrderId", origClientOrderId)
                .toString();
    }
}
