package com.hackerrank.restcontrolleradvice.controller;

import com.hackerrank.restcontrolleradvice.dto.*;
import com.hackerrank.restcontrolleradvice.enums.FizzBuzzEnum;
import com.hackerrank.restcontrolleradvice.exception.FizzBuzzExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class FizzBuzzController {

  private FizzBuzzExceptionHandler handler = new FizzBuzzExceptionHandler();

  @RequestMapping(value = "/controller_advice/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getFizzBuzzResponse(@PathVariable("code") String code)
          throws FizzException, BuzzException, FizzBuzzException
  {


    if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
      throw new FizzException("Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

    } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {
      throw new BuzzException(
              "Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
      throw new FizzException(
              "Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
    return ResponseEntity.ok(new FizzBuzzResponse("", HttpStatus.OK.value()));
  }
}
