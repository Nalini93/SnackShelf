package com.snackshelf;

import com.snackshelf.products.Product;
import com.snackshelf.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@SpringBootApplication
public class SnackShelfApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private OrderRepository orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(SnackShelfApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		//orderRepo.deleteAll();
		//userRepo.deleteAll();
		//productRepo.deleteAll();

		System.out.println("Orders found with findAll():");
		System.out.println("-------------------------------");
		for(Order order : orderRepo.findAll()){
			System.out.println(order);
		}

		/*System.out.println("Products found with findAll():");
		System.out.println("-------------------------------");
		for(Product product : productRepo.findAll()){
			System.out.println(product);
		}
		System.out.println("prova");*/


		ArrayList<String> lista = new ArrayList<>();
		for(Product product1 : productRepo.findAll()){
			lista.add(product1.getId());
			System.out.println(product1.toString());
		}

		if(lista.contains("5c49bf2d43db564664609c9b")){
			System.out.println("va");
		}else{
			System.out.println("non va");
		}
	}
}