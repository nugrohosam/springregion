package com.nugrohosamiyono.springregion.Middlewares;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Applications.AuthenticateApplication;
import com.nugrohosamiyono.springregion.Exceptions.UnauthorizedException;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfoGrpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMiddleware {

    @Autowired
    private AuthenticateApplication authenticateApplication;

    public FilterChain checkAuth(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws InterruptedException, UnauthorizedException {
        String authorization = request.getHeader("Authorization");
        AuthInfoGrpc authInfoGrpc = this.authenticateApplication.authenticateGrpc(authorization);
        if (authInfoGrpc.getId() == 0) {
            throw new UnauthorizedException();
        }

        return filterChain;
    }
}
