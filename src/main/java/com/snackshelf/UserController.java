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
import org.apache.commons.lang3.StringUtils;

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
	 public User getUserById(@PathVariable("id") String id) throws UserNotFoundRequestException {
		/*ArrayList<String> lista= new ArrayList<String>();
		   for(User user1: repository.findAll()) {
			   lista.add(user1.get_id());  
		   }
		   if(lista.contains(id.toHexString())) {
				return repository.findBy_id(id);
		   }else {
			   throw new UserNotFoundRequestException();
		   }*/
		if(id.length()!=24) {
			throw new UserNotFoundRequestException();
		}else {
		if(repository.existsById(id)){
	  		return repository.findBy_id(new ObjectId(id));
	  		
		}else{
			throw new UserNotFoundRequestException();
		}
		}

	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyUserById(@PathVariable("id") String id, @Valid @RequestBody User user) throws UserBadRequestException, UserNotFoundRequestException {
	  
	   if(id.length()!=24) {
			throw new UserNotFoundRequestException();
		}else {
			 user.set_id(new ObjectId(id));
	   if(StringUtils.isEmpty(user.getName())|| StringUtils.isEmpty(user.getSurname()))  {
		   throw new UserBadRequestException(); 
	   }else if(repository.existsById(id)){
	   
	   repository.save(user);
	   }else {
		   throw new UserNotFoundRequestException();
	   	}
		}
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public User createUser(@Valid @RequestBody User user) throws UserBadRequestException{
	   user.set_id(ObjectId.get());
	   if(StringUtils.isEmpty(user.getName())|| StringUtils.isEmpty(user.getSurname())){
		   throw new UserBadRequestException();
		}else{
	   		
	   		repository.save(user);
	   	}
	   return user;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteUser(@PathVariable String id) throws UserNotFoundRequestException {
		
		 if(id.length()!=24) {
				throw new UserNotFoundRequestException();
		 }else {
				if(repository.existsById(id)){ 
			   /*for(Order order1: repository1.findByuser(repository.findBy_id(id))) {
				   repository1.delete(order1);
		   	}*/
		   	repository.delete(repository.findBy_id(new ObjectId(id)));
		   	
		   }else {
		  throw new UserNotFoundRequestException();
	  }
	}
	}
}