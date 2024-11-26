package com.example.tienda_emazon.domain.model;

public class CategoryInfo {
    private Long id;
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryInfo(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
