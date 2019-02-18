package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
@CrossOrigin(origins = "http://localhost:4200")
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
	
	public List getAllOrders() throws OrderNotFoundRequestException{
		if(repository.findAll().isEmpty()){
			throw new OrderNotFoundRequestException();
		}else {
	 return repository.findAll();
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Order getOrderById(@PathVariable("id") String id) throws OrderNotFoundRequestException{
		/*ArrayList<String> lista3= new ArrayList<String>();
		for(Order order1: repository.findAll()) {
			   lista3.add(order1.get_id());  
		   }*/
		if(id.length()!=24) {
			throw new OrderNotFoundRequestException();
		}else {
		if(repository.existsById(id)){
	  		return repository.findBy_id(new ObjectId(id));
	  		
		}else{
			throw new OrderNotFoundRequestException();
		}
		}
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyOrderById(@PathVariable("id") String id, @Valid @RequestBody Order order) throws OrderBadRequestException, OrderNotFoundRequestException {
	   
	   boolean productsexist= true;
	   for(Product product1:order.getProducts())
	   {
		   if(!repository2.existsById(product1.getId().toString())) 
			   //if(!repositoryprod.existsById(product1.getId().toString()))
			   productsexist=false;
		   
	   }
	   if(id.length()!=24) {
			throw new OrderNotFoundRequestException();
		}else {
			 order.set_id(new ObjectId(id));
	
	   if(order.getTotal()<=0 ||StringUtils.isEmpty(Double.toString(order.getTotal()))) {
		   throw new OrderBadRequestException();
	   }else {
		   if(repository1.existsById((order.getuser().get_id())) && productsexist && repository.existsById(id) /*&& order.getuser().equals(repository1.findById(order.getuser().get_id()))*/) {
		   		repository.save(order);
		   	}else {
		   		if(!repository.existsById(id)) {
		   		throw new OrderNotFoundRequestException();
		   		}else {
		   			throw new OrderBadRequestException();
		   		}
		   	}
	   	}
		}
	  }
	
	//POST
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Order createOrder(@Valid @RequestBody Order order) throws OrderBadRequestException, OrderNotFoundRequestException {
		System.out.println(order);
		order.set_id(ObjectId.get());
		//for(Product product: order.getproducts())
		
	  if(order.getTotal()<=0 || order.getuser()==null || order.getProducts()==null ||StringUtils.isEmpty(Double.toString(order.getTotal())) ) {
		  throw new OrderBadRequestException();
	   }else {
		   	if(repository1.existsById(order.getuser().get_id()) && productExists(order)) {
		   		
		   		updateproductStock(order);
		   		repository.save(order);
		   	}else {
		   		throw new OrderBadRequestException();
		   	}
	   }
	   return order;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteOrder(@PathVariable String id) throws OrderNotFoundRequestException {

		 if(id.length()!=24) {
				throw new UserNotFoundRequestException();
		 }else {
		if(repository.existsById(id)) {
	   repository.delete(repository.findBy_id(new ObjectId(id)));
	  }else {
		  throw new OrderNotFoundRequestException();
	  
	  	}
		 }
	}
	
	@RequestMapping(value = "/listorder/{id}", method = RequestMethod.GET)
	public List<Order> OrderByUser(@PathVariable("id") String id) throws OrderNotFoundRequestException {
		List<Order> orderlist;
		User user1;
		user1=repository1.findBy_id(new ObjectId(id));
		if(user1==null) {
			throw new UserNotFoundRequestException();
		}else {
		orderlist=repository.findByuser(user1);
		if((orderlist==null)) {
			throw new OrderNotFoundRequestException();	
		}
		}
		return orderlist;
	}
	
	public boolean productExists(Order order) {
		boolean productsexist=true;
		for(Product product1:order.getProducts()) {
			if(!repository2.existsById(product1.getId().toString())) {
				
				productsexist=false;
			}else {
				Product product2=repository2.findBy_id(new ObjectId(product1.getId()));
				if(product1.quantity>product2.quantity) {
					productsexist=false;
				}
			}
		}
		return productsexist;	
	}
	
	
	
	public void updateproductStock (Order order){
		List<Product> listproducts=order.getProducts();
		System.out.println(listproducts);
		for(Product product1:order.getProducts()) {
			if(repository2.existsById(product1.getId().toString())) {
			Product product2 = repository2.findBy_id(new ObjectId(product1.getId()));
				product2.decreaseQuantity();
				repository2.save(product2);	
			}			
		}
	}
	
	
	

	}