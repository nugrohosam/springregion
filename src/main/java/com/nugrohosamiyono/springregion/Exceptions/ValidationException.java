package com.nugrohosamiyono.springregion.Exceptions;

import java.util.List;
import org.springframework.validation.FieldError;

public class ValidationException extends Exception {
    public List<FieldError> validationErrors;

    public ValidationException(List<FieldError> validationErrors) {
        super();
        this.validationErrors = validationErrors;
    }
}
