package com.snackshelf.orders;
import com.snackshelf.orders.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository <Order, String>{
	Order findBy_id(ObjectId _id);
}