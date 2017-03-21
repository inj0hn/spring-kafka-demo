package com.vagrant;

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
	private static final String PERSON_TOPIC_NAME = "vagrant-kafka-person-poc";
	
	@Autowired
	@Qualifier(value="kafkaTemplate")
	private KafkaTemplate<Integer, String> template;
	
	@Autowired
	@Qualifier(value="kafkaPersonTemplate")
	private KafkaTemplate<String, Person> personTemplate;
	
	@Test
	public void receiveMessage() throws Exception {
		template.sendDefault("payload message without topic name passed");
		template.send("new-topic", "New TOPIC");
		template.send(TOPIC_NAME, "foo");
		template.send(TOPIC_NAME, "bar");
		template.send(TOPIC_NAME, "abc");
		template.send(TOPIC_NAME, "xyz");
	}
	
	@Test
	public void sendPerson() throws Exception {
		Person john = new Person(Person.Gender.MALE, "John", "Smith");
		Person jane = new Person(Person.Gender.FEMALE, "Jane", "Doe");
		personTemplate.send(PERSON_TOPIC_NAME, john);
		personTemplate.sendDefault(jane);
	}

}
