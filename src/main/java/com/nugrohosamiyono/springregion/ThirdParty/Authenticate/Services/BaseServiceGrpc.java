package com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseServiceGrpc {

    @Value("${authenticate-grpc.service.host}")
    protected String host;

    @Value("${authenticate-grpc.service.port}")
    protected int port;
}