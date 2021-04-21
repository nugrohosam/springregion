package com.nugrohosamiyono.springregion.Responses;

public class Pagination {
    public int page;
    public int perPage;
    public int total;

    public Pagination(){
    }
    
    public Pagination(int page, int perPage, int total){
        this.page = page;
        this.perPage = perPage;
        this.total = total;
    }
}
