package com.shaheen.activemqpoc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaheen.activemqpoc.model.HelloModel;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
  private Integer counter = 0;
  private final MessageProducer messageProducer;

  public HelloService(MessageProducer messageProducer) {
    this.messageProducer = messageProducer;
  }

  public HelloModel sayHello(HelloModel helloModel) throws JsonProcessingException {
    helloModel.setMessageId(++counter);
    String message = new ObjectMapper().writeValueAsString(helloModel);
    messageProducer.sendMessage(message);
    return helloModel;
  }
}
