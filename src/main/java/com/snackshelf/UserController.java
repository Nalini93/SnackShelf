package com.snackshelf;

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
@RequestMapping("/user")
public class UserController{
	@Autowired
   	private UserRepository repository;

   	//GET
   	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List getAllUsers(){
   		return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") ObjectId id){
   		return repository.findBy_id(id);
   	}
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user){
		user.set_id(id);
	   	repository.save(user);
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		user.set_id(ObjectId.get());
	   	repository.save(user);
	   	return user;
	}
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}