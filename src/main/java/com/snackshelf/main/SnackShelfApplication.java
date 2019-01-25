package com.snackshelf.main;

import com.snackshelf.users.User;
import com.snackshelf.users.UserRepository;
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