package ru.geekbrains.homework6.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.homework6.exceptions.NoSuchExecutorException;
import ru.geekbrains.homework6.exceptions.NoSuchTaskException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoSuchTaskException.class)
    public ResponseEntity<?> handleTaskNotFoundException(NoSuchTaskException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(NoSuchExecutorException.class)
    public ResponseEntity<?> handleExecutorNotFoundException(NoSuchExecutorException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage() + " Not Found");
    }
}


