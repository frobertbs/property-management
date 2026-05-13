package com.frobertbs.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorModel> handleBusinessException(BusinessException ex) {
        ErrorModel error = new ErrorModel();
        error.setCode("BUSINESS_ERROR");
        error.setMessage("An business error occurred.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handleValidationException(MethodArgumentNotValidException ex) {
        ErrorModel error = new ErrorModel();
        error.setCode("VALIDATION_ERROR");
        error.setMessage("Validation failed for the request.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
