package com.abhisheksah;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.abhisheksah.model.Owner;
import com.abhisheksah.model.User;
import com.abhisheksah.repository.OwnerRepository;

@SpringBootApplication
@EnableEurekaClient
public class OwnerMicroservicesApplication {

//	@Autowired
//	private OwnerRepository repository;
//	
//	 @PostConstruct
//	    public void initUsers() {
//	        List<Owner> owner = Stream.of(
//	        		new Owner("101", "Abhishek", "abhi", "abhi@gmail.com","8787878787"),
//	        		new Owner("102", "Aman", "aman", "aman@gmail.com","7878787878"),
//	        		new Owner("103", "aniket", "aniket", "aniket@gmail.com","7979797979"),
//	        		new Owner("104", "rahul", "rahul", "rahul@gmail.com","9797979797")
//	        ).collect(Collectors.toList());
//	        repository.saveAll(owner);
//	    }
//	
	public static void main(String[] args) {
		SpringApplication.run(OwnerMicroservicesApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
