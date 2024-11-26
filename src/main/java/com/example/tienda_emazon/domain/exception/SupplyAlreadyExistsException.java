package com.example.tienda_emazon.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class SupplyAlreadyExistsException extends RuntimeException {

    public SupplyAlreadyExistsException(String message){
        super(message);
    }
    @ExceptionHandler(value = {SupplyAlreadyExistsException.class})
    public ResponseEntity<Object> handlerBadRequestExceptionSupply(SupplyAlreadyExistsException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage());
        return new ResponseEntity<>(errorResponse, badRequest);
}
}
