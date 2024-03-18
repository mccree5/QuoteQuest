package com.example.demo.Controller;

import com.example.demo.Service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
    public class CustomExceptionHandler {

        @ExceptionHandler(Service.ToDoItemNotFoundException.class)
        public ResponseEntity<Object> handleNotFoundException(Service.ToDoItemNotFoundException ex) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

