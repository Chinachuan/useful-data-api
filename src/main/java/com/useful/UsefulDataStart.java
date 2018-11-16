package com.useful;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class,DataSourceAutoConfiguration.class})
@EnableScheduling
@ComponentScan(basePackages = {"com.useful.support.**","com.useful.**"}) 
public class UsefulDataStart {
	
	private static Logger logger = LoggerFactory.getLogger(UsefulDataStart.class);
	
	public static void main(String[] args) throws UnknownHostException {
		   Environment env = SpringApplication.run(UsefulDataStart.class, args).getEnvironment();
		   logger.info("\n----------------------------------------------------------\n\t" +
					"Application '{}' is running! Access URLs:\n\t" +
					"Local: \t\thttp://localhost:{}\n\t" +
					"External: \t\thttp://{}:{}\n\t----------------------------------------------------------",
			env.getProperty("spring.application.name"),
			env.getProperty("server.port"),
			InetAddress.getLocalHost().getHostAddress(),
			env.getProperty("server.port"),
			env.getProperty("server.port")); 

		   logger.info("\n----------------------------------------------------------\n\t");
			
	}
}

