package com.nugrohosamiyono.springregion.Helpers.Responses;

public class ResponseData extends Response {    
    public Object data;

    public ResponseData(Object data) {
        this.data =data;
        this.statusCode =  200;
    }
}