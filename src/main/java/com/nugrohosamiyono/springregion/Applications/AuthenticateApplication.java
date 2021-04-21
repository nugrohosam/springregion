package com.nugrohosamiyono.springregion.Applications;

import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfo;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services.AuthenticateServiceGrpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateApplication {

    @Autowired
    AuthenticateServiceGrpc authenticateGrpc;

    public AuthInfo authenticateGrpc(String token) throws InterruptedException {
        return authenticateGrpc.authInfo(token);
    }
}
