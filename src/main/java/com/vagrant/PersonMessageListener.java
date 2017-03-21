package com.vagrant;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class PersonMessageListener implements MessageListener<String, Person> {

	@Override
	public void onMessage(ConsumerRecord<String, Person> data) {
		System.out.println("[*] Message received " + data);
		System.out.println("[*] Person object received: " + data.value());
	}

}
