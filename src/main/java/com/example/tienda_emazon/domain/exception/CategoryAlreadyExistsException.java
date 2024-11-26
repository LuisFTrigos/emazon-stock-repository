package com.example.tienda_emazon.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CategoryAlreadyExistsException extends RuntimeException {

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
    @ExceptionHandler(value = {CategoryAlreadyExistsException.class})
    public ResponseEntity<Object> handlerBadRequestExceptionCategory(CategoryAlreadyExistsException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage()
        );
        return new ResponseEntity<>(errorResponse, badRequest);
    }
}
