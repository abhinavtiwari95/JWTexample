package com.jwtexample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.jwtexample.entity.User;
import com.jwtexample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtExampleApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "tiwari","Tiw@ri","tiwari@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
}
