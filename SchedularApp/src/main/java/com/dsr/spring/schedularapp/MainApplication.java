package com.dsr.spring.schedularapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dsr.spring.schedularapp.processor.TaskSchedular;

/**
 * Spring boot Main class.
 *
 */

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MainApplication.class,
				args);
		TaskSchedular taskSchedular = ctx.getBean(TaskSchedular.class);
		taskSchedular.startProcessing();
	}
}
