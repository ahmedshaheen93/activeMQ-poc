package com.shaheen.activemqpoc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageProducer {
  private JmsTemplate jmsTemplate;



  @Autowired
  public MessageProducer(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  public void sendMessage(String message) {
    jmsTemplate.convertAndSend("my_queue", message);
    log.info("Message sent: {}", message);
  }
}
