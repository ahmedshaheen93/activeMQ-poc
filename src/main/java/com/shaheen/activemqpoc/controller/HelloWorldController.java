package com.shaheen.activemqpoc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shaheen.activemqpoc.model.HelloModel;
import com.shaheen.activemqpoc.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  private final HelloService helloService;

  public HelloWorldController(HelloService helloService) {
    this.helloService = helloService;
  }

  @PostMapping("/sayHello")
  public ResponseEntity<HelloModel> sayHello(@RequestBody HelloModel helloModel) throws JsonProcessingException {
    helloModel  = helloService.sayHello(helloModel);
    return new ResponseEntity<>(helloModel, HttpStatus.ACCEPTED);
  }
}
