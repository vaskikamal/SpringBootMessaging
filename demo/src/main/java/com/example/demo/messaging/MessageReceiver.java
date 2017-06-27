package com.example.demo.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver implements MessageListener{

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	
	@Autowired
	MessageConverter messageConverter;
	
	@Override
	public void onMessage(Message message) {
		LOG.info("-----------------------------------------------------");
		LOG.info("Application : order received : {}",message);	
		LOG.info("-----------------------------------------------------");
		try {
			message.acknowledge();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

