package com.nugrohosamiyono.springregion.Helpers;

import java.util.List;

import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
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

    public static Response responseError(String message) {
        return (new ResponseError(message));
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
}
