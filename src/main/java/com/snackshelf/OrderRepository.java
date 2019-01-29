package com.snackshelf;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository <Order, String>{
	Order findBy_id(ObjectId _id);
	List<Order> findByuser(User user);
	
}