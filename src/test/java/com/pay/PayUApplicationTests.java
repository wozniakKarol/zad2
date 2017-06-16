package com.pay;

import com.pay.model.OauthResponse;
import com.pay.model.OrderCreateRequest;
import com.pay.model.OrderCreateResponse;
import com.pay.model.Product;
import com.pay.service.oAuth.OAuthService;
import com.pay.service.order.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.pay.model.CurrencyCode.PLN;
import static com.pay.util.Credential.CLIENT_ID;
import static com.pay.util.Credential.SHOP_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayUApplicationTests {

    @Autowired
    private OAuthService oAuthService;

    @Autowired
    private OrderService orderService;

    private OrderCreateRequest orderCreateRequest;
    private OauthResponse oauthResponse;

    @Before
    public void setUp() {
        Product product1 = new Product("Watch", 10000L, 1);
        Product product2 = new Product("Computer", 200000L, 1);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        orderCreateRequest = new OrderCreateRequest(SHOP_URL, CLIENT_ID.toString(), "shop", PLN, productList);
        oauthResponse = oAuthService.getOauthResponse();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateOrder() {
        OrderCreateResponse orderCreateResponse = orderService.createOrder(orderCreateRequest, oauthResponse);
        assertNotNull(orderCreateResponse.getOrderId());
        assertNotNull(orderCreateResponse.getRedirectUri());
        assertEquals("SUCCESS", orderCreateResponse.getStatus().getStatusCode());
        System.out.println(orderCreateResponse.getRedirectUri());
    }

}
