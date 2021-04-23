package com.nugrohosamiyono.springregion.Applications;

import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfoGrpc;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services.AuthenticateServiceProto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionApplication {

    @Autowired
    AuthenticateServiceProto authenticateGrpc;

    public AuthInfoGrpc authenticateGrpc(String token) throws InterruptedException {
        return authenticateGrpc.authInfo(token);
    }
}
