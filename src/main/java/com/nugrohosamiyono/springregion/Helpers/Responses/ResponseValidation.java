
package com.nugrohosamiyono.springregion.Helpers.Responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.validation.FieldError;
import java.util.Map;


public class ResponseValidation extends Response {
    public List<Map<String, Object>> errors;

    public ResponseValidation(List<FieldError> errors) {
        List<Map<String, Object>> errorValidation = new ArrayList<>();

        for (FieldError objectError : errors) {
            Map<String, Object> validation = new HashMap<String, Object>();
            validation.put("field", objectError.getField());
            validation.put("error", objectError.getDefaultMessage());
            errorValidation.add(validation);
        }

        this.errors = errorValidation;
        this.statusCode =  400;
    }
}