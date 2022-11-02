package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.azure.data.appconfiguration.models.ConfigurationSetting;

@SpringBootApplication
@RestController
public class DemoApplication {

	Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		logger.debug("************************************* Start");
		
		ConfigurationClient configurationClient = new ConfigurationClientBuilder()
			    .connectionString("Endpoint=https://appconf-ncus-dev-apim-001.azconfig.io;Id=hoKr-l7-s0:q+4N3KLIQsVMXv87bgmr;Secret=0Z9olEgIxz7ZMLnAVU+sPybQM2WKKq5WUA3J5x6jP6o=")
			    .buildClient();
		
		String retrievedSetting = configurationClient.getConfigurationSetting("TEMP_STRING", "").getValue(); //config manager (local = xxx)
		String retrievedSetting2 = configurationClient.getConfigurationSetting("TEST_CONFIG1", "").getValue(); //config manager (local = xxx)

		String value2 = System.getenv("TEMP_STRING"); //app and config manager (local = null)
		String value3 = System.getenv("TEMP_STRING2"); //app (local = null) 
		String value4 = System.getenv("TEST_CONFIG1");  //config manager (local = null)

		logger.debug("************************************* Return");
		
		return "Hello Azure : {" + retrievedSetting + "," + value2 + "," + value3 + "," + value4 + "," + retrievedSetting2 + "}!";
	}
}
