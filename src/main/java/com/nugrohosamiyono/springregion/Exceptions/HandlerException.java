package com.nugrohosamiyono.springregion.Exceptions;

import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseError;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseValidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleExceptions(ValidationException exception, WebRequest webRequest) {
        ResponseValidation responseError = new ResponseValidation(exception.validationErrors);
        ResponseEntity<Object> response = new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<Object> handleExceptions(MessageException exception, WebRequest webRequest) {
        ResponseError responseError = new ResponseError(exception.getMessage(), 400);
        ResponseEntity<Object> response = new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleExceptions(AccessDeniedException exception, WebRequest webRequest) {
        ResponseError responseError = new ResponseError("Access Denied", 401);
        ResponseEntity<Object> response = new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
        return response;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleExceptions(RuntimeException exception, WebRequest webRequest) {
        System.out.println("RuntimeException");
        ResponseError responseError = new ResponseError(exception.getMessage(), 500);
        ResponseEntity<Object> response = new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}