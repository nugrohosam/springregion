package com.nugrohosamiyono.springregion.Middlewares;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Global.LocaleInfo;

import org.springframework.stereotype.Component;

@Component
public class LocaleMiddleware {

    public static void checkLang(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        LocaleInfo.regionCode = request.getHeader("Localization");
    }

    public static void checkTime(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

    }
}
