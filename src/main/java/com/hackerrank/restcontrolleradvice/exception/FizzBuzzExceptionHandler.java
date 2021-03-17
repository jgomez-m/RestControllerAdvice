package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.*;
import com.hackerrank.restcontrolleradvice.enums.FizzBuzzEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({FizzException.class, BuzzException.class, FizzBuzzException.class})
    public ResponseEntity<GlobalError> handleExceptions(RuntimeException exception) {

        if (exception instanceof FizzException) {
            return new ResponseEntity<>(new GlobalError(
                    exception.getMessage(),((FizzException) exception).getErrorReason()),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        } else if (exception instanceof BuzzException) {
            return new ResponseEntity<>(new GlobalError(
                    exception.getMessage(), ((BuzzException) exception).getErrorReason()),
                    HttpStatus.BAD_REQUEST);

        } else if (exception instanceof FizzBuzzException) {
            return new ResponseEntity<>(new GlobalError(
                    exception.getMessage(), ((FizzBuzzException) exception).getErrorReason()),
                    HttpStatus.INSUFFICIENT_STORAGE);
        }
        return null;
    }
}
