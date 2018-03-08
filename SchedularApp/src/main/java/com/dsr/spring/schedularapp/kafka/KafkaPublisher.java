package com.dsr.spring.schedularapp.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaPublisher {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(KafkaPublisher.class);

	private String kafkaTopic;

	public KafkaPublisher(final String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String payload) {
		LOGGER.info("sending message='{}' to topic='{}'", payload, kafkaTopic);
		kafkaTemplate.send(kafkaTopic, payload);
	}

}
