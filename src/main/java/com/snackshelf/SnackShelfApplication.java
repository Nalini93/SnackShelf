package com.snackshelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnackShelfApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SnackShelfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Products found with findAll():");
		System.out.println("-------------------------------");
		for(User user : userRepo.findAll()){
			System.out.println(user);
		}
	}
}