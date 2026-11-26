package com.sd.Server;

import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Map<String, String>> notFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Não encontrado"));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Map<String, String>> duplicate(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "Já existe"));
    }
}
