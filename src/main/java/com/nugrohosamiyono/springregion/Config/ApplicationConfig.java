package com.nugrohosamiyono.springregion.Config;

import java.io.IOException;

import com.nugrohosamiyono.springregion.Exceptions.UnauthorizedException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Middlewares.AuthorizationMiddleware;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class ApplicationConfig {

    @Autowired
    AuthorizationMiddleware authorizationMiddleware;

    @Bean
    public Filter globalFilter() {
        return new OncePerRequestFilter() {

            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                    FilterChain filterChain) throws UnauthorizedException, ServletException, IOException {

                filterChain = Base.mapQueryParams(request, response, filterChain);
            }
        };
    }
}