package com.ubaid.jconnect.namingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServer {

	public static void main(String[] args) {
		SpringApplication.run(NamingServer.class, args);
	}

}
