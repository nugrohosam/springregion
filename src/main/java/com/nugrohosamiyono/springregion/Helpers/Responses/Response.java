package com.nugrohosamiyono.springregion.Helpers.Responses;

import org.springframework.beans.factory.annotation.Value;

public class Response {
    public Integer statusCode;

    @Value("${app.version}")
    public String version;
}