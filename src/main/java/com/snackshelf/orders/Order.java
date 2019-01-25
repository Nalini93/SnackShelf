package com.snackshelf.orders;

import com.snackshelf.users.User;
import com.snackshelf.products.Product;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import com.snackshelf.*;

@Document(collection = "orders")
public class Order implements Serializable{
	@Id
	public ObjectId _id;
	public int quantity;
	public double total;
	@DBRef
	@Field("users")
	public User user;

	@DBRef
	@Field("products")
	public Product product;
 
	public Order() {
		
	}
 
	public Order(User user,Product product, int quantity, double total) {
		this.user = user;
		this.product=product;
		this.quantity = quantity;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [_id=" + _id + ", quantity=" + quantity + ", total=" + total + ", user=" + user + ", product="
				+ product + "]";
	}
}