package com.nugrohosamiyono.springregion.Exceptions;

import com.nugrohosamiyono.springregion.Helpers.ResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleExceptions(RuntimeException exception, WebRequest webRequest) {
        ResponseError responseError = new ResponseError(exception.getMessage());
        ResponseEntity<Object> response = new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
        return response;
    }
}