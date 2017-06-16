package com.pay.service.oAuth;

import com.pay.model.OauthResponse;
import com.pay.util.Credential;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuthServiceImpl implements OAuthService {

    private final RestTemplate restTemplate;

    public OAuthServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public OauthResponse getOauthResponse() {
        OauthResponse oauthResponse = this.restTemplate.getForObject("https://secure.snd.payu.com/pl/standard/user/oauth/authorize?grant_type={gra}&client_id={id}&client_secret={secret}",
                OauthResponse.class, Credential.GRANT_TYPE, Credential.CLIENT_ID, Credential.CLIENT_SECRET);
        return oauthResponse;
    }
}
