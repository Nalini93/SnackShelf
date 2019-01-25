package com.snackshelf;

import com.snackshelf.Order;
import com.snackshelf.OrderRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
  public class OrderController {
   @Autowired
   private OrderRepository repository;
   @Autowired
   private UserRepository repository1;
   @Autowired
   private ProductRepository repository2;
  

   //get 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public List getAllOrders() throws OrderNotFoundRequestException {
		if(repository.findAll().isEmpty()) {
			throw new OrderNotFoundRequestException();
		}else {
	 return repository.findAll();
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Order getOrderById(@PathVariable("id") ObjectId id) throws OrderBadRequestException {
		ArrayList<String> lista3= new ArrayList<String>();
		for(Order order1: repository.findAll()) {
			   lista3.add(order1.get_id());  
		   }
		if(lista3.contains(id)) {
	  return repository.findBy_id(id);
		}else {
			throw new OrderBadRequestException();
		}
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyOrderById(@PathVariable("id") ObjectId id, @Valid @RequestBody Order order) throws OrderBadRequestException {
	   order.set_id(id);
	   ArrayList<String> lista= new ArrayList<String>();
	   ArrayList<String> lista2= new ArrayList<String>();
	   ArrayList<String> lista3= new ArrayList<String>();
	   
	   for(User user: repository1.findAll()) {
		   lista.add(user.get_id());  
	   }
	   for(Product product: repository2.findAll()) {
		   lista2.add(product.get_id());
	   }
	   
	   for(Order order1: repository.findAll()) {
		   lista3.add(order1.get_id());  
	   }
	   if(order.getQuantity()<=0|| order.getTotal()<=0 || order.getuser()==null || order.getProduct()==null ) {
		   throw new OrderBadRequestException();
	   }else {
		   if(lista.contains(order.getuser().get_id()) && lista2.contains(order.getProduct().get_id()) && lista3.contains(id.toHexString())) {
		   		
		   		repository.save(order);
		   		
		   	}else {  
		   		
		   		throw new OrderBadRequestException();
		   	}
	   }
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Order createOrder(@Valid @RequestBody Order order) throws OrderBadRequestException {
	   order.set_id(ObjectId.get());
	   ArrayList<String> lista= new ArrayList<String>();
	   ArrayList<String> lista2= new ArrayList<String>();
	   for(User user: repository1.findAll()) {
		   lista.add(user.get_id());  
	   }
	   for(Product product: repository2.findAll()) {
		   lista2.add(product.get_id());
	   }
	   //System.out.println(lista);
	   
	  if(order.getQuantity()<=0|| order.getTotal()<=0 || order.getuser()==null || order.getProduct()==null) {
		  throw new OrderBadRequestException();
	   }else {
		   	if(lista.contains(order.getuser().get_id()) && lista2.contains(order.getProduct().get_id())) {
		   		
		   		repository.save(order);
		   		
		   	}else {  
		   		
		   		throw new OrderBadRequestException();
		   	}
	   }
	   return order;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteOrder(@PathVariable ObjectId id) throws OrderNotFoundRequestException {
		ArrayList<String> lista3= new ArrayList<String>();
		for(Order order1: repository.findAll()) {
			   lista3.add(order1.get_id());  
		   }
		if(lista3.contains(id)) {
	   repository.delete(repository.findBy_id(id));
	  }else {
		  throw new OrderNotFoundRequestException();
	  }


	}
}
