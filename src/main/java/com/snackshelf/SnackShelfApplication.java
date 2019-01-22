package com.snackshelf;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;







@SpringBootApplication
public class SnackShelfApplication implements CommandLineRunner {
	
	
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private OrderRepository repository1;
	public static void main(String[] args) {
		SpringApplication.run(SnackShelfApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//ArrayList users= new ArrayList();
		//repository.deleteAll();
		//users.add(new User("John","Smith"));
		//repository.saveAll(users);
		
		
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		
		//ArrayList orders= new ArrayList();
		//orders.add(new Order(1,20.0));
		

		System.out.println("Orders found with findAll():");
		System.out.println("-------------------------------");
		for (Order order : repository1.findAll()) {
			System.out.println(order);
		}
		
	}
	
}