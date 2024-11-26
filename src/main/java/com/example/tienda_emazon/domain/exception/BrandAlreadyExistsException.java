package com.example.tienda_emazon.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BrandAlreadyExistsException extends RuntimeException{

    public BrandAlreadyExistsException(String message){
        super(message);
    }
    @ExceptionHandler(value = {BrandAlreadyExistsException.class})
    public ResponseEntity<Object> handlerBadRequestExceptionBrand(BrandAlreadyExistsException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage()
        );
        return new ResponseEntity<>(errorResponse, badRequest);
    }

}
