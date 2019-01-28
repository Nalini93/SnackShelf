package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/users")
  public class UserController{
   @Autowired
   private UserRepository repository;
   @Autowired
   private OrderRepository repository1;
   //get 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public List getAllUsers() throws UserNotFoundRequestException{
		if(repository.findAll().isEmpty()) {
			throw new UserNotFoundRequestException();
		}else
	 return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public User getUserById(@PathVariable("id") ObjectId id) throws UserNotFoundRequestException {
		ArrayList<String> lista= new ArrayList<String>();
		   for(User user1: repository.findAll()) {
			   lista.add(user1.get_id());  
		   }
		   if(lista.contains(id.toHexString())) {
				return repository.findBy_id(id);
		   }else {
			   throw new UserNotFoundRequestException();
		   }
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) throws UserBadRequestException, UserNotFoundRequestException {
	   user.set_id(id);
	   ArrayList<String> lista= new ArrayList<String>();
	   for(User user1: repository.findAll()) {
		   lista.add(user1.get_id());  
	   }
	   if(user.getName()==null|| user.getSurname()==null)  {
		   throw new UserBadRequestException(); 
	   }else if(lista.contains(user.get_id())){
	   
	   repository.save(user);
	   }else {
		   throw new UserNotFoundRequestException();
	   }
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public User createUser(@Valid @RequestBody User user) throws UserBadRequestException{
	   user.set_id(ObjectId.get());
	   if(user.getName()==null|| user.getSurname()==null){
		   throw new UserBadRequestException();
		}else{
	   		System.out.println("prova");
	   		repository.save(user);
	   	}
	   return user;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteUser(@PathVariable ObjectId id) throws UserNotFoundRequestException {
		ArrayList<String> lista= new ArrayList<String>();
		
		   for(User user1: repository.findAll()) {
			   lista.add(user1.get_id());  
		   }
		   if(lista.contains(id.toHexString())) {
			  
			   for(Order order1: repository1.findByuser(repository.findBy_id(id))) {
				   repository1.delete(order1);
		   	}
		   	repository.delete(repository.findBy_id(id));
		   	
		   }else {
		  throw new UserNotFoundRequestException();
	  }
	}
}