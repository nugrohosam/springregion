package com.nugrohosamiyono.springregion.Helpers;

import java.util.Iterator;

public class ResponseItems extends Response {    
    public Iterator<Object> items;

    public ResponseItems(Iterator<Object> items) {
        this.items = items;
        this.status_code = 200;
    }
}