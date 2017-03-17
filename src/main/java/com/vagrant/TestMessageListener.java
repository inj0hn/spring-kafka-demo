package com.vagrant;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class TestMessageListener implements MessageListener<String, String> {

	public void onMessage(ConsumerRecord<String, String> data) {
		System.out.println("[*] Message received " + data);
	}

}
