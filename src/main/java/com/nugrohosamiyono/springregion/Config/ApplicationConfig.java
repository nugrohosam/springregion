package com.nugrohosamiyono.springregion.Config;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nugrohosamiyono.springregion.Helpers.Base;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class ApplicationConfig {

    @Bean
    public Filter snakeConverter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                    FilterChain filterChain) throws ServletException, IOException {
                final Map<String, String[]> formattedParams = new ConcurrentHashMap<>();

                for (String param : request.getParameterMap().keySet()) {
                    String formattedParam = Base.snakeCaseToCamelCase(param);
                    formattedParams.put(formattedParam, request.getParameterValues(param));
                }

                filterChain.doFilter(new HttpServletRequestWrapper(request) {
                    @Override
                    public String getParameter(String name) {
                        return formattedParams.containsKey(name) ? formattedParams.get(name)[0] : null;
                    }

                    @Override
                    public Enumeration<String> getParameterNames() {
                        return Collections.enumeration(formattedParams.keySet());
                    }

                    @Override
                    public String[] getParameterValues(String name) {
                        return formattedParams.get(name);
                    }

                    @Override
                    public Map<String, String[]> getParameterMap() {
                        return formattedParams;
                    }
                }, response);
            }
        };
    }
}