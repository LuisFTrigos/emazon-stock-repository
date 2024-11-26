package com.example.tienda_emazon.infrastructure.configuration;

import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.exception.CategoryDuplicatedException;
import com.example.tienda_emazon.domain.exception.SupplyAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(SupplyAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleSupplyAlreadyExistsException(SupplyAlreadyExistsException e){
        Map<String, Object> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoryDuplicatedException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryAlreadyExistsException(CategoryDuplicatedException e){
        Map<String, Object> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleBrandAlreadyExistsException(BrandAlreadyExistsException e){
        Map<String, Object> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryAlreadyExistsDefined(CategoryAlreadyExistsException e){
        Map<String, Object> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


}
