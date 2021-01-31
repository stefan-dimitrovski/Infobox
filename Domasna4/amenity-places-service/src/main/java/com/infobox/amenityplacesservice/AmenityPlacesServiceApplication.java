package com.infobox.amenityplacesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
public class AmenityPlacesServiceApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Sleeping for 20 seconds");
		TimeUnit.SECONDS.sleep(20);
		SpringApplication.run(AmenityPlacesServiceApplication.class, args);
	}

}
