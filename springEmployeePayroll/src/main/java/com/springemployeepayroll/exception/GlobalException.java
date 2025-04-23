package com.springemployeepayroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException extends RuntimeException {

   @ExceptionHandler(EmpException.class)
    public ResponseEntity<?> handleExp(final EmpException ex) {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
   }
}
