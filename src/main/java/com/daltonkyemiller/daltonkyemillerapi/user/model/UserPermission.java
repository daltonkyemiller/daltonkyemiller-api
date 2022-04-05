package com.daltonkyemiller.daltonkyemillerapi.user.model;

public enum UserPermission {
    PROJECT_READ("project:read"),
    PROJECT_WRITE("project:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
