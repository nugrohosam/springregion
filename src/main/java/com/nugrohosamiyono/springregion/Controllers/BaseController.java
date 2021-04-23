package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Applications.AuthenticateApplication;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BaseController {

    @Autowired
    AuthenticateApplication AuthenticateApplication;

    @GetMapping("/grpc")
    public Response index() throws InterruptedException {
        String message = "Failed to authenticate";
        return Base.responseMessage(message);
    }
}