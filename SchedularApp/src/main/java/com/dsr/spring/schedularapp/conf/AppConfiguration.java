package com.dsr.spring.schedularapp.conf;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.dsr.spring.schedularapp.processor.Task;
import com.dsr.spring.schedularapp.rest.RestClient;

@Configuration
public class AppConfiguration {

	@Autowired
	private  AppProperties properties;

    @Bean(name = "taskExecutor" )
    public ExecutorService getTaskExecutor() {
    	return Executors.newFixedThreadPool(properties.getThreadpoolsize());
    }
    
    @Bean(name = "priorityQueue" )
    public PriorityBlockingQueue<Task> getPriorityQueue() {
    	return new PriorityBlockingQueue<Task>(properties.getQueuesize(), Comparator.comparing(Task::getCount));
    }
    
    
    @Bean(name = "restTemplate" )
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	return new RestTemplate();
	}
    
    @Bean(name = "restClient" )
   	public RestClient getRestClient() {
       	return new RestClient();
   	}
    
}
