package com.hmc.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";
    private static final String URI_CLIENT_AUTHENTICATE = "/api/login";


    public FeignClientInterceptor() {
    }

//    public ClientAuthentication getClientAuthentication() {
//        return clientAuthentication;
//    }
//
//    public void setClientAuthentication(ClientAuthentication clientAuthentication) {
//        this.clientAuthentication = clientAuthentication;
//    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (requestTemplate.url().contains(URI_CLIENT_AUTHENTICATE)) {
            return;
        }
        requestTemplate.header(AUTHORIZATION_HEADER,
                String.format("%s %s", TOKEN_TYPE, SecurityUtils.getTokenCurrent()));
    }
}
