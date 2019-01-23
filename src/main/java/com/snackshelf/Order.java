package com.snackshelf;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import com.snackshelf.User;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "orders")
public class Order implements Serializable{
	@Id
	public ObjectId _id;
	public int quantity;
	public double total;
	@DBRef
	@Field("users")
	public User user;

	public Order(){}
	public Order(int quantity, double total){
		this.quantity = quantity;
		this.total = total;
	}
	public ObjectId get_id() {
		return _id;
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
		return "Order [_id=" + _id + ", quantity=" + quantity + ", total=" + total + ", user=" + user + "]";
	}
}