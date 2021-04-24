package com.nugrohosamiyono.springregion.Helpers.Responses;

import java.util.List;

public class ResponseItems extends Response {    
    public List<Object> items;

    public ResponseItems(List<Object> items) {
        this.items = items;
        this.statusCode =  200;
    }
}