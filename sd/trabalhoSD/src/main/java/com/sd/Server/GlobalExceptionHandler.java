package com.sd.Server;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> notFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não encontrado");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> duplicate(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe");
    }
}
