package com.nugrohosamiyono.springregion.Helpers.Responses;

public class ResponseError extends Response {    
    public String message;

    public ResponseError(String message, Integer statucCode) {
        this.message = message;
        this.statusCode = statucCode;
    }
}