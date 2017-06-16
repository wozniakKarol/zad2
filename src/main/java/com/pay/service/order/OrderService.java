package com.pay.service.order;


import com.pay.model.OauthResponse;
import com.pay.model.OrderCreateRequest;
import com.pay.model.OrderCreateResponse;

public interface OrderService {

    OrderCreateResponse createOrder(OrderCreateRequest orderCreateRequest, OauthResponse oauthResponse);
}
