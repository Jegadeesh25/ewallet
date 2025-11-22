package com.ewallet.product.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException ex) {

        Map<String, Object> res = new HashMap<>();
        res.put("timestamp", LocalDateTime.now().toString());
        res.put("error", ex.getMessage());
        res.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {

        Map<String, Object> res = new HashMap<>();
        res.put("timestamp", LocalDateTime.now().toString());
        res.put("error", "Internal Server Error");
        res.put("details", ex.getMessage());
        res.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

