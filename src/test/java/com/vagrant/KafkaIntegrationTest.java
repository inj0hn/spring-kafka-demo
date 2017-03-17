package com.vagrant;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class KafkaIntegrationTest {
	private static final String TOPIC_NAME = "vagrant-kafka-poc";
	
	@Autowired
	private KafkaTemplate<Integer, String> template;
	@Autowired
	@Qualifier("consumerProps")
	private Map<String, Object> consumerProps;
	@Autowired
	@Qualifier("producerProps")
	private Map<String, Object> producerProps;
	
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
