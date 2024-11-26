package com.example.tienda_emazon.domain.model.page;

public class PageRequestDomain {

    private Integer page;
    private Integer size;
    private String sortDirection;
    private String sortBy;

    public PageRequestDomain() {
    }

    public PageRequestDomain(Integer page, Integer size, String sortDirection, String sortBy) {
        this.page = page;
        this.size = size;
        this.sortDirection = sortDirection;
        this.sortBy = sortBy;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
