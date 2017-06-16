package com.pay.service.order;

import com.google.gson.Gson;
import com.pay.model.OauthResponse;
import com.pay.model.OrderCreateRequest;
import com.pay.model.OrderCreateResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl implements OrderService {

    private final RestTemplate restTemplate;

    public OrderServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public OrderCreateResponse createOrder(OrderCreateRequest orderCreateRequest, OauthResponse oauthResponse) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", oauthResponse.getAuthentication());
        headers.setContentType(MediaType.APPLICATION_JSON);

        Gson gson = new Gson();

        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(orderCreateRequest), headers);


        OrderCreateResponse orderCreateResponse = restTemplate.postForObject("https://secure.snd.payu.com/api/v2_1/orders",
                entity, OrderCreateResponse.class);
        return orderCreateResponse;
    }
}
