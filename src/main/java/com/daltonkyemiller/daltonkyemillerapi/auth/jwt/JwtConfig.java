package com.daltonkyemiller.daltonkyemillerapi.auth.jwt;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import javax.crypto.SecretKey;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String tokenPrefix;
    private String secret;
    private Integer tokenExpiresAfterDays;

    public JwtConfig() {

    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getTokenExpiresAfterDays() {
        return tokenExpiresAfterDays;
    }

    public void setTokenExpiresAfterDays(Integer tokenExpiresAfterDays) {
        this.tokenExpiresAfterDays = tokenExpiresAfterDays;
    }

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

}
