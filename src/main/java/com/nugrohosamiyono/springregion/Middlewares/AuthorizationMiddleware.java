package com.nugrohosamiyono.springregion.Middlewares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Applications.AuthenticateApplication;
import com.nugrohosamiyono.springregion.Exceptions.UnauthorizedException;
import com.nugrohosamiyono.springregion.Global.AuthInfo;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfoGrpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMiddleware {

    public final static String API = "auth_api";

    @Autowired
    private AuthenticateApplication authenticateApplication;

    public void checkAuth(String type, HttpServletRequest request, HttpServletResponse response)
            throws UnauthorizedException {
        String authorization = request.getHeader("Authorization");

        if (authorization == null){
            throw new UnauthorizedException();
        }

        switch (type) {
        case API:
            this.checkAuthAPI(authorization, request, response);
            break;
        default:
            // try another auth here
        }
    }

    private void checkAuthAPI(String authorization, HttpServletRequest request, HttpServletResponse response)
            throws UnauthorizedException {

        try {
            AuthInfoGrpc authInfoGrpc = this.authenticateApplication.authenticateGrpc(authorization);

            if (authInfoGrpc.getId() == 0) {
                throw new UnauthorizedException();
            }

            AuthInfo.email = authInfoGrpc.getEmail();
            AuthInfo.id = (int) authInfoGrpc.getId();

        } catch (InterruptedException exception) {
            throw new UnauthorizedException();
        }
    }

    public void checkRoles(HttpServletRequest request, HttpServletResponse response, String roles[])
            throws UnauthorizedException {
        if (roles == null) {
            return;
        }

        String role = request.getHeader("Role");
        throw new UnauthorizedException();
    }

    public void checkPermission(HttpServletRequest request, HttpServletResponse response, String permissions[])
            throws UnauthorizedException {
        if (permissions == null) {
            return;
        }

        String permission = request.getHeader("Permission");
        throw new UnauthorizedException();
    }
}
