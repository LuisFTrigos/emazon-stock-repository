package com.example.tienda_emazon.domain.model;

import java.util.Objects;

public class CategoryModel {

    private long id;
    private String categoryName;
    private String categoryDescription;

    public CategoryModel() { /**/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return id == that.id && Objects.equals(categoryName, that.categoryName) && Objects.equals(categoryDescription, that.categoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryDescription);
    }
}
