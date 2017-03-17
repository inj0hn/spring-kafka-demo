package com.vagrant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class KafkaIntegrationTest {
	private static final String TOPIC_NAME = "vagrant-kafka-poc";
	
	@Autowired
	private KafkaTemplate<Integer, String> template;
	
	@Test
	public void receiveMessage() throws Exception {
		template.sendDefault("payload message without topic name passed");
		template.send("new-topic", "New TOPIC");
		template.send(TOPIC_NAME, "foo");
		template.send(TOPIC_NAME, "bar");
		template.send(TOPIC_NAME, "abc");
		template.send(TOPIC_NAME, "xyz");
	}

}
