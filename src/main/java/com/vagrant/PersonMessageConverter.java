package com.vagrant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author vagrant
 *
 */
public class PersonMessageConverter implements Serializer<Person>, Deserializer<Person> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonMessageConverter.class);
	
	@Override
	public void close() {
		LOG.info("Closing PersonMessageConverter");
	}
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		LOG.info("Configuring PersonMessageConverter. isKey: {}", isKey);
		if(configs!=null) {
			configs.forEach(
				(key, value) -> {
					LOG.info("key: {}, value:{}", key, value);
			});
		}
	}
	
	@Override
	public byte[] serialize(String key, Person value) {
		LOG.info("Key: {}\nSerializing Person.\n{}", key, value);
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(value);
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return new byte[0];
	}
	
	@Override
	public Person deserialize(String key, byte[] value) {
		LOG.info("Key: {}\nDeserializing byte array.", key);
		try (ByteArrayInputStream bis = new ByteArrayInputStream(value);
				ObjectInputStream ois = new ObjectInputStream(bis)){
			return (Person) ois.readObject();
		}catch(Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}
}
