package com.nugrohosamiyono.springregion.Helpers.Responses;

public class ResponseMessage extends Response {
    public Object message;

    public ResponseMessage(String message) {
        this.message = message;
        this.status_code = 200;
    }
}