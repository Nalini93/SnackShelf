package com.snackshelf;

import com.snackshelf.User;
import com.snackshelf.Product;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.snackshelf.*;

@Document(collection = "orders")
public class Order implements Serializable{
	@Id
	public ObjectId _id;
	public double total;
	//@DBRef
	@Field("users")
	public User user;

	//@DBRef
	@Field("products")
	public List<Product> products;
 
	public Order() {
		
	}
 
	public Order(User user,List<Product> products,double total) {
		this.user = user;
		this.products=products;
		this.total = total;
	}

	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public User getuser() {
		return user;
	}
	public void setuser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [_id=" + _id + ", total=" + total + ", user=" + user + ", products=" + products + "]";
	}
	


	

	
}