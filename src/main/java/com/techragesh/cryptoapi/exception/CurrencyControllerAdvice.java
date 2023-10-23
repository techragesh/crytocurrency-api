package com.techragesh.cryptoapi.exception;

/**
 * Create a class CurrencyControllerAdvice extends ResponseEntityExceptionHandler with the following methods:
 * 1. handleDataNotFoundException
 * 2. handleTechnicalException
 * Return ProblemDetail object with the following details:
 * 1. status: HttpStatus.NOT_FOUND
 * 2. message: "Data not found"
 * 3. timestamp: current timestamp
 * 4. details: exception message
 * Return ProblemDetail object with the following details:
 * 1. status: HttpStatus.INTERNAL_SERVER_ERROR
 * 2. message: "Technical error"
 * 3. timestamp: current timestamp
 * 4. details: exception message
 * Use @RestControllerAdvice annotation to make this class as an Exception Handler.
 * Use @ExceptionHandler annotation to handle DataNotFoundException.
 * Use @ExceptionHandler annotation to handle TechnicalException.
 * Use @ResponseStatus annotation to set HttpStatus.NOT_FOUND.
 * Use @ResponseStatus annotation to set HttpStatus.INTERNAL_SERVER_ERROR.
 * Use @ResponseBody annotation to return ProblemDetail object.
 */

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CurrencyControllerAdvice extends ResponseEntityExceptionHandler{

  @ExceptionHandler(DataNotFoundException.class)
  public ProblemDetail handleDataNotFoundException(DataNotFoundException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    problemDetail.setTitle("Data not found");
    problemDetail.setType(URI.create("http://api/v1/currency/not-found"));
    problemDetail.setDetail(ex.getMessage());
    problemDetail.setStatus(HttpStatus.NOT_FOUND);
    return problemDetail;
  }

  @ExceptionHandler(TechnicalException.class)
  public ProblemDetail handleTechnicalException(TechnicalException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    problemDetail.setTitle("Technical error");
    problemDetail.setType(URI.create("http://api/v1/currency/technical-error"));
    problemDetail.setDetail(ex.getMessage());
    problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    return problemDetail;
  }

}
