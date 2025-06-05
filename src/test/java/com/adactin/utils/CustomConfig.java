package com.adactin.utils;

import java.util.Properties;

public class CustomConfig {

    private final String username;
    private final String password;

    public CustomConfig(Properties properties) {
        username = properties.getProperty("user.name");
        password = properties.getProperty("user.password");
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}