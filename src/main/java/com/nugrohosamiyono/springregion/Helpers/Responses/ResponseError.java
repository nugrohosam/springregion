package com.nugrohosamiyono.springregion.Helpers.Responses;

public class ResponseError extends Response {    
    public String message;

    public ResponseError(String message) {
        this.message = message;
        this.status_code = 400;
    }
}