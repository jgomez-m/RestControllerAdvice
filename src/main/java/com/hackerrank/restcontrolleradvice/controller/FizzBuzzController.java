package com.hackerrank.restcontrolleradvice.controller;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzResponse;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.enums.FizzBuzzEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class FizzBuzzController extends ResponseEntityExceptionHandler {

  @RequestMapping(value = "/controller_advice/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ExceptionHandler({FizzException.class, BuzzException.class, FizzBuzzException.class})
  public ResponseEntity<Object> getFizzBuzzResponse(@PathVariable("code") String code, WebRequest request)
  {

    ResponseEntity<Object> response = null;
    if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
      response = handleExceptionInternal(new FizzException("Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
              new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.value()),
              new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {
      response = handleExceptionInternal(new FizzException("Buzz Exception has been thrown", HttpStatus.BAD_REQUEST.getReasonPhrase()),
              new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.BAD_REQUEST.value()),
              new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
      response = handleExceptionInternal(new FizzBuzzException("FizzBuzz Exception has been thrown", HttpStatus.INSUFFICIENT_STORAGE.getReasonPhrase()),
              new FizzBuzzResponse("Fizz Exception has been thrown", HttpStatus.INSUFFICIENT_STORAGE.value()),
              new HttpHeaders(), HttpStatus.INSUFFICIENT_STORAGE, request);
    }
    return response;
  }
}
