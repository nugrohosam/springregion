package com.nugrohosamiyono.springregion.Middlewares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Global.LocaleInfo;

import org.springframework.stereotype.Component;

@Component
public class LocaleMiddleware {

    public void checkLang(HttpServletRequest request, HttpServletResponse response) {
        LocaleInfo.regionCode = request.getHeader("Localization");
    }
}
