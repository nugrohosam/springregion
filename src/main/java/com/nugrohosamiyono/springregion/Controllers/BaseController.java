package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services.AuthenticateService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BaseController {

    @GetMapping("/grpc")
    public Response index() {
        AuthenticateService.authenticate(null);
        return Base.responseMessage("Success");
    }
}