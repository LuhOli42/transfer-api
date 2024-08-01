package com.apiebanxs.pvd_api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AccountNotFoundException.class)
  public ResponseEntity<Integer> handleAccountNotFoundException(
    AccountNotFoundException ex
  ) {
    return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
  }
}
