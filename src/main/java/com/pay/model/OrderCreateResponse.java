package com.pay.model;


public class OrderCreateResponse {

    private OrderCreateResponseStatus status;
    private String redirectUri;
    private String orderId;


    public OrderCreateResponseStatus getStatus() {
        return status;
    }

    public void setStatus(OrderCreateResponseStatus status) {
        this.status = status;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
