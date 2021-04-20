package com.nugrohosamiyono.springregion.Helpers;

import java.util.List;

public class ResponseItems extends Response {    
    public List<Object> items;

    public ResponseItems(List<Object> items) {
        this.items = items;
        this.status_code = 200;
    }
}