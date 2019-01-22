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
import java.util.List;

@RestController
@RequestMapping("/order")
  public class OrderController {
   @Autowired
   private OrderRepository repository;
   
   @Autowired
   private UserRepository repository1;

   //get 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public List getAllOrders() {
	 return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Order getOrderById(@PathVariable("id") ObjectId id) {
	  return repository.findBy_id(id);
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyOrderById(@PathVariable("id") ObjectId id, @Valid @RequestBody Order order) {
	   order.set_id(id);
	   repository.save(order);
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Order createOrder(@Valid @RequestBody Order order,User user) {
	   order.set_id(ObjectId.get());
	   repository.save(order);
	   repository1.save(user);
	   return order;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteOrder(@PathVariable ObjectId id) {
	   repository.delete(repository.findBy_id(id));
	  }


	
}
