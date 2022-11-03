package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.example.demo.model.Thing;

@SpringBootApplication
@RestController
public class DemoApplication {

	Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	List<Thing> sayHello() {
		logger.debug("************************************* Start");
		
		ConfigurationClient configurationClient = new ConfigurationClientBuilder()
			    .connectionString("Endpoint=https://appconf-ncus-dev-apim-001.azconfig.io;Id=hoKr-l7-s0:q+4N3KLIQsVMXv87bgmr;Secret=0Z9olEgIxz7ZMLnAVU+sPybQM2WKKq5WUA3J5x6jP6o=")
			    .buildClient();

		logger.debug("************************************* Return");
				
		List<Thing> listOfThings = new ArrayList<>();
		listOfThings.add(new Thing("TEMP_STRING", System.getenv("TEMP_STRING"), "AS & CM", "howdy"));
		listOfThings.add(new Thing("TEMP_STRING2", System.getenv("TEMP_STRING2"), "AS", "hello"));
		listOfThings.add(new Thing("TEST_CONFIG1", System.getenv("TEST_CONFIG1"), "CM", "null"));
		listOfThings.add(new Thing("TEMP_STRING", configurationClient.getConfigurationSetting("TEMP_STRING", "").getValue(), "CM", "howdy-doo"));
		listOfThings.add(new Thing("TEST_CONFIG1", configurationClient.getConfigurationSetting("TEST_CONFIG1", "").getValue(), "CM", "5"));
		
		
		return listOfThings;
	}
}
