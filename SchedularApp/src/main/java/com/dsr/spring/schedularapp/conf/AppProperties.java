package com.dsr.spring.schedularapp.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

	private int threadpoolsize;
	private int queuesize;

	public int getThreadpoolsize() {
		return threadpoolsize;
	}

	public void setThreadpoolsize(int threadpoolsize) {
		this.threadpoolsize = threadpoolsize;
	}

	public int getQueuesize() {
		return queuesize;
	}

	public void setQueuesize(int queuesize) {
		this.queuesize = queuesize;
	}

}
