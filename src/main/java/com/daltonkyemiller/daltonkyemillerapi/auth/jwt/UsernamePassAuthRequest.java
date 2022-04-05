package com.daltonkyemiller.daltonkyemillerapi.auth.jwt;

public class UsernamePassAuthRequest {
    private String username;
    private String password;

    public UsernamePassAuthRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
