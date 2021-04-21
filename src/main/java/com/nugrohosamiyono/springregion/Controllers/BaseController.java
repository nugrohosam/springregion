package com.nugrohosamiyono.springregion.Controllers;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.AuthenticateApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BaseController {

    @Autowired
    AuthenticateApplication AuthenticateApplication;

    @GetMapping("/grpc")
    public Response index(@RequestHeader HttpHeaders headers) throws InterruptedException {
        String authorization = headers.getFirst("Authorization");  

        AuthInfo authInfo = AuthenticateApplication.authenticateGrpc(authorization);

        String message = "Failed to authenticate";
        if (authInfo.getId() != 0) {
            message = "Success to authenticate";
        }

        return Base.responseMessage(message);
    }
}