package com.pay.model;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static ch.lambdaj.Lambda.sumFrom;
import static org.apache.commons.lang.StringUtils.EMPTY;


public class OrderCreateRequest {


    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private CurrencyCode currencyCode;
    private Long totalAmount;
    private List<Product> products;

    public OrderCreateRequest(String notifyUrl, String merchantPosId, String description, CurrencyCode currencyCode, List<Product> products) {
        this.notifyUrl = notifyUrl;
        this.customerIp = createHostAddress();
        this.merchantPosId = merchantPosId;
        this.description = description;
        this.currencyCode = currencyCode;
        this.products = products;
        this.totalAmount = sumFrom(products).getUnitPrice();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public void setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private String createHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return EMPTY;
        }
    }
}
