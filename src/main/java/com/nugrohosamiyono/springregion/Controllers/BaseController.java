package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BaseController {

    @GetMapping("/")
    public Response index() throws InterruptedException {
        String message = "Region services";
        return Base.responseMessage(message);
    }
}