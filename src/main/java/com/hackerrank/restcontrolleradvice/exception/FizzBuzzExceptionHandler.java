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

    @ExceptionHandler({FizzBuzzException.class, BuzzException.class, FizzBuzzException.class})
    public ResponseEntity<Object> handleExceptions(RuntimeException exception) {
        ResponseEntity<Object> response = null;
        if (exception instanceof FizzException) {
            response = handleExceptionInternal(exception,
                    new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, null);

        } else if (exception instanceof BuzzException) {
            response = handleExceptionInternal(new BuzzException("Buzz Exception has been thrown", HttpStatus.BAD_REQUEST.getReasonPhrase()),
                    new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.BAD_REQUEST.value()),
                    new HttpHeaders(), HttpStatus.BAD_REQUEST, null);

        } else if (exception instanceof FizzBuzzException) {
            response = handleExceptionInternal(new FizzBuzzException("FizzBuzz Exception has been thrown", HttpStatus.INSUFFICIENT_STORAGE.getReasonPhrase()),
                    new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.INSUFFICIENT_STORAGE.value()),
                    new HttpHeaders(), HttpStatus.INSUFFICIENT_STORAGE, null);
        }
        return response;
    }
}
