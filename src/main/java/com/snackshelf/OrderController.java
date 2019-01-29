package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

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
	 public Order getOrderById(@PathVariable("id") ObjectId id) throws OrderNotFoundRequestException{
		/*ArrayList<String> lista3= new ArrayList<String>();
		for(Order order1: repository.findAll()) {
			   lista3.add(order1.get_id());  
		   }*/
		if(repository.existsById(id.toHexString())){
	  		return repository.findBy_id(id);
	  		
		}else{
			throw new OrderNotFoundRequestException();
		}
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyOrderById(@PathVariable("id") ObjectId id, @Valid @RequestBody Order order) throws OrderBadRequestException, OrderNotFoundRequestException {
	   order.set_id(id);
	   boolean productsexist= true;
	   for(Product product1:order.getProducts())
	   {
		   if(!repository2.existsById(product1.getId().toString())) 
			   //if(!repositoryprod.existsById(product1.getId().toString()))
			   productsexist=false;
		   
	   }
	   /*ArrayList<String> lista= new ArrayList<String>();
	   ArrayList<String> lista2= new ArrayList<String>();
	   ArrayList<String> lista3= new ArrayList<String>();
	   
	   for(User user: repository1.findAll()) {
		   lista.add(user.get_id());  
	   }
	  
	   for(Order order1: repository.findAll()) {
		   lista3.add(order1.get_id());
	   }*/
	   if(order.getQuantity()<=0|| order.getTotal()<=0 || StringUtils.isEmpty(Integer.toString(order.getQuantity()))||StringUtils.isEmpty(Double.toString(order.getTotal()))) {
		   throw new OrderBadRequestException();
	   }else {
		   if(repository1.existsById((order.getuser().get_id())) && productsexist && repository.existsById(id.toHexString())) {
		   		repository.save(order);
		   	}else {
		   		throw new OrderNotFoundRequestException();
		   	}
	   }
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Order createOrder(@Valid @RequestBody Order order) throws OrderBadRequestException, OrderNotFoundRequestException {
	   order.set_id(ObjectId.get());
	   boolean productsexist= true;
	   for(Product product1:order.getProducts())
	   {
		   if(!repository2.existsById(product1.getId().toString())) 
			   //if(!repositoryprod.existsById(product1.getId().toString()))
			   productsexist=false;
		   
	   }
	   //ArrayList<String> lista= new ArrayList<String>();
	   //ArrayList<String> lista2= new ArrayList<String>();
	   /*for(User user: repository1.findAll()) {
		   lista.add(user.get_id());  
	   }*/
	   /*for(Product product: repository2.findAll()) {
		   lista2.add(product.getId());
	   }*/

	  if(order.getQuantity()<=0|| order.getTotal()<=0 || order.getuser()==null || order.getProducts()==null || StringUtils.isEmpty(Integer.toString(order.getQuantity()))||StringUtils.isEmpty(Double.toString(order.getTotal())) ) {
		  throw new OrderBadRequestException();
	   }else {
		   	if(repository1.existsById(order.getuser().get_id()) && productsexist) {
		   		repository.save(order);
		   	}else {
		   		throw new OrderNotFoundRequestException();
		   	}
	   }
	   return order;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteOrder(@PathVariable ObjectId id) throws OrderNotFoundRequestException {
		/*ArrayList<String> lista3= new ArrayList<String>();
		for(Order order1: repository.findAll()) {
			   lista3.add(order1.get_id());  
		   }*/
		if(repository.existsById(id.toHexString())) {
	   repository.delete(repository.findBy_id(id));
	  }else {
		  throw new OrderNotFoundRequestException();
	  
	}
}
 }