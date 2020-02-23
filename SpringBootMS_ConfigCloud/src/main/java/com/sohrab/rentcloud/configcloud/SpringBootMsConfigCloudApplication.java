package com.sohrab.rentcloud.configcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootMsConfigCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsConfigCloudApplication.class, args);
	}

}
