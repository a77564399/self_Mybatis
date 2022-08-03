package com.class04.day01.mybatis.cfg;

import com.class04.day01.mybatis.Mapper.Mapper;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private String Driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<>();
    public Configuration() {
    }

    public Configuration(String driver, String url, String username, String password) {
        Driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
