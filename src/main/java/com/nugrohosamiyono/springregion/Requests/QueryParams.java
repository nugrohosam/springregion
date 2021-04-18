package com.nugrohosamiyono.springregion.Requests;

public class QueryParams {
    
    private boolean pagination;
    private int perPage;
    private int page;
    private String search;

    public String getSearch() {
        return search;
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
