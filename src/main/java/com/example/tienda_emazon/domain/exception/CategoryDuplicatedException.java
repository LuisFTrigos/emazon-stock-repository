package com.example.tienda_emazon.domain.exception;

public class CategoryDuplicatedException extends RuntimeException{
    public CategoryDuplicatedException(String message) {
        super(message);
    }
}
