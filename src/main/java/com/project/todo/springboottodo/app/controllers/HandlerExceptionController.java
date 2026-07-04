package com.project.todo.springboottodo.app.controllers;

import com.project.todo.springboottodo.app.exceptions.NoTaskException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.project.todo.springboottodo.app.entities.Error;

import java.time.LocalDate;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> handlerNotFound(NoHandlerFoundException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoTaskException.class)
    public ResponseEntity<Error> handlerTaskNotFound(NoTaskException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handlerBadRequest(HttpMessageNotReadableException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
