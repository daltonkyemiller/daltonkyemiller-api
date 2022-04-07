package com.daltonkyemiller.daltonkyemillerapi.exception;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiError extends Throwable{
    private final String message;
    private final String reason;

    public ApiError(String message, String reason) {
        this.message = message;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public Map<String, String> toMap(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("message", this.getMessage());
        map.put("reason", this.getReason());
        return map;
    }
}
