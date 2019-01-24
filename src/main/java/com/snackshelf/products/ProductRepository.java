package com.snackshelf.products;

import com.snackshelf.products.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
    Product findBy_id(ObjectId _id);
}