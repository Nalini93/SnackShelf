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
  public class OrderController{
	  @Autowired
   	  private OrderRepository orderRepo;
   	  @Autowired
   	  private UserRepository userRepo;
   	  @Autowired
	  private ProductRepository productRepo;
   //GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List getAllOrders() {
	 return orderRepo.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("id") ObjectId id){
		//productRepo.findBy_id(id);
		//userRepo.findBy_id(id);
		return orderRepo.findBy_id(id);
	}
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyOrderById(@PathVariable("id") ObjectId id, @Valid @RequestBody Order order) {
		order.set_id(id);
	   	orderRepo.save(order);
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Order createOrder(@Valid @RequestBody Order order, User user, ObjectId id){
		user = userRepo.findBy_id(id);
		System.out.println(user.toString());

		if(user.getName() == null){
			System.err.println("prova");
		}else{
			orderRepo.save(order);
			System.out.println(orderRepo);
			System.out.println(user);
		}
	   	return order;
	}
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteOrder(@PathVariable ObjectId id){
		orderRepo.delete(orderRepo.findBy_id(id));
	  }
}