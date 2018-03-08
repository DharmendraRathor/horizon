package com.dsr.spring.schedularapp.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsr.spring.schedularapp.conf.AppProperties;
import com.dsr.spring.schedularapp.kafka.KafkaPublisher;
import com.dsr.spring.schedularapp.rest.RestClient;

@Component
public class TaskSchedular {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TaskSchedular.class);

	@Autowired
	AppProperties properties;

	@Autowired
	PriorityBlockingQueue<Task> priorityQueue;

	@Autowired
	ExecutorService taskExecutor;

	@Autowired
	KafkaPublisher kafkaPublisher;

	@Autowired
	RestClient RestClient;

	public void startProcessing() {

		Thread thread = new Thread(() -> {
			LOGGER.info("Polling...");
			while (true) {
				try {
					LOGGER.info("Before Poll");
					Task poll = priorityQueue.take();
					LOGGER.info("Polled START: '{}'", poll.getJobName());
					taskExecutor.execute(poll);
					LOGGER.info("Polled END:: '{}'", poll.getJobName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();

		// submitting 3 task for testing.
		Task task1 = new Task("one", priorityQueue, System.currentTimeMillis(),
				kafkaPublisher, RestClient);
		priorityQueue.add(task1);
		Task task2 = new Task("two", priorityQueue, System.currentTimeMillis(),
				kafkaPublisher, RestClient);
		priorityQueue.add(task2);
		Task task3 = new Task("three", priorityQueue,
				System.currentTimeMillis(), kafkaPublisher, RestClient);
		priorityQueue.add(task3);
	}
}
