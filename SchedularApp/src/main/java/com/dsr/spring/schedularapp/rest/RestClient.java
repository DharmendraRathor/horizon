package com.dsr.spring.schedularapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RestClient.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getEntity(){
	// use restTemplate to make http call.
	LOGGER.info("inside getEntity method");
	  return "test data";	
	}
	
	public void postEntity(){
		// use restTemplate to make http call.
	}
	
}
