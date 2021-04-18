package com.nugrohosamiyono.springregion.Helpers;

public class ResponsePagination extends Response {    
    public Object data;

    public ResponsePagination(Object data) {
        this.data =data;
        this.status_code = 200;
    }
}