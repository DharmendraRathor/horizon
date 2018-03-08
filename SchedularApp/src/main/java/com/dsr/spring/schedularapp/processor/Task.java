package com.dsr.spring.schedularapp.processor;

import java.util.concurrent.PriorityBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsr.spring.schedularapp.kafka.KafkaPublisher;
import com.dsr.spring.schedularapp.rest.RestClient;

public class Task implements Runnable, Comparable<Task> {
	private String jobName;
	private long time;
	private PriorityBlockingQueue<Task> queue;
	private KafkaPublisher kafkaPublisher;
	private RestClient restClient;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Task.class);

	public Task(final String jobName,final  PriorityBlockingQueue<Task> queue, final long count,
			final KafkaPublisher kafkaPublisher,final RestClient restClient) {
		this.jobName = jobName;
		this.queue = queue;
		this.time = count;
		this.kafkaPublisher = kafkaPublisher;
		this.restClient = restClient;
	}

	public int compareTo(Task o) {
		if (this.time > o.getCount()) {
			return 1;
		} else if (this.time == o.getCount()) {
			return -1;
		} else {
			return 0;
		}
	}

	public long getCount() {
		return time;
	}

	public void setCount(int time) {
		this.time = time;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void run() {
		try {
			// perform operation
			restClient.getEntity();
			LOGGER.info("Task-jobName='{}' time='{}'",jobName,time);
			Thread.sleep(1000);
			// post the message to kafka;
			String message = "Task:" + jobName + " count " + time;
			kafkaPublisher.send(message);
			this.time = this.time + 100;

			queue.add(this);
		} catch (InterruptedException ignored) {
		}
	}
}