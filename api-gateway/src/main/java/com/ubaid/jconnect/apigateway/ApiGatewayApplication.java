package com.ubaid.jconnect.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/jtech/messages/**")
						.uri("lb://MESSAGES"))
				.route(r -> r.path("/jtech/notifications/**")
						.uri("lb://NOTIFICATION"))
				.route(r -> r.path("/jtech/sessions/**")
						.uri("lb://SESSION"))
				.route(r -> r.path("/jtech/users/**")
						.uri("lb://USERS"))
				.build();
	}


}
