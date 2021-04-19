package com.nugrohosamiyono.springregion.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Helpers.ResponseError;

@ControllerAdvice
public class HandlerValidationException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final Response handleConstraintViolationExceptions(ConstraintViolationException ex) {
        String exceptionResponse = String.format("Invalid input parameters: %s\n", ex.getMessage());
        return (new ResponseError(exceptionResponse));
    }
}