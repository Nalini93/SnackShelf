package com.snackshelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SnackShelfApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private OrderRepository orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(SnackShelfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for(User user : userRepo.findAll()){
			System.out.println(user);
		}
	
		System.out.println("Products found with findAll():");
		System.out.println("-------------------------------");
		for(Product product : prodRepo.findAll()){
			System.out.println(product);
		}
		
		System.out.println("Orders found with findAll():");
		System.out.println("-------------------------------");
		for(Order order : orderRepo.findAll()){
			System.out.println(order);
		}
		
	}
}