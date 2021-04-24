package com.nugrohosamiyono.springregion.Helpers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseData;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseError;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseItems;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseMessage;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponsePagination;
import com.nugrohosamiyono.springregion.Responses.Pagination;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Component
public class Base {

    public static String snakeCaseToCamelCase(String str) {
        while (str.contains("_")) {
            str = str.replaceFirst("_[a-z]", String.valueOf(Character.toUpperCase(str.charAt(str.indexOf("_") + 1))));
        }

        return str;
    }

    public static void validationCheck(Errors errors) throws ValidationException {
        if (errors.hasErrors()) {
            List<FieldError> objecteErrors = errors.getFieldErrors();
            throw new ValidationException(objecteErrors);
        }
    }

    public static Response responseError(String message, Integer statusCode) {
        return (new ResponseError(message, statusCode));
    }

    public static Response responseMessage(String message) {
        return (new ResponseMessage(message));
    }

    public static Response responsePagination(List<Object> data, Pagination pagination) {
        return (new ResponsePagination(data, pagination));
    }

    public static Response responseData(Object data) {
        return (new ResponseData(data));
    }

    public static Response responseList(List<Object> data) {
        return (new ResponseItems(data));
    }

    public static String queryWhereIn(List<Object> data) {
        String dataToString[] = new String[data.size()];
        int index = 0;
        for (Object list : data) {
            dataToString[index] = list.toString();
            index++;
        }

        return "(" + String.join(",", dataToString) + ")";
    }

    public static boolean inArray(String find, Object dataSearch[]){
        return Arrays.asList(dataSearch).contains(find);
    }

    public static FilterChain mapQueryParams(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        final Map<String, String[]> formattedParams = new ConcurrentHashMap<>();

        for (String param : request.getParameterMap().keySet()) {
            String formattedParam = Base.snakeCaseToCamelCase(param);
            formattedParams.put(formattedParam, request.getParameterValues(param));
        }

        HttpServletRequest httpServletRequest = new HttpServletRequestWrapper(request) {
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
        };

        filterChain.doFilter(httpServletRequest, response);

        return filterChain;
    }
}
