package com.nugrohosamiyono.springregion.Helpers.Responses;

import java.util.List;

import com.nugrohosamiyono.springregion.Responses.Pagination;

public class ResponsePagination extends Response {
    
    public List<Object> items;
    public int page;
    public int perPage;
    public int total;

    public ResponsePagination(List<Object> items, Pagination pagination) {
        this.items = items;
        this.total = pagination.total;
        this.perPage = pagination.perPage;
        this.page = pagination.page;
        this.statusCode =  200;
    }
}