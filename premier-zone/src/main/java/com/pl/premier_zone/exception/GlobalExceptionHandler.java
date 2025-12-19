package com.pl.premier_zone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex)
    {
        Map<String, Object> m = new HashMap<>();

        m.put("timestamp", LocalDateTime.now());
        m.put("error", ex.getMessage());
        m.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
