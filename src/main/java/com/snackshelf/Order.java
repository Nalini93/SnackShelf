package com.snackshelf;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
public class Order {



	@Id
	public ObjectId _orderid, _userid;
	
	public int quantity;
	public double total;
 
	public Order() {
		
	}
 
	public Order(ObjectId _orderid, ObjectId _userid, int quantity, double total) {
		
		this._orderid = _orderid;
		this._userid = _userid;
		this.quantity = quantity;
		this.total = total;
	}

	public ObjectId get_orderid() {
		return _orderid;
	}

	public void set_orderid(ObjectId _orderid) {
		this._orderid = _orderid;
	}

	public ObjectId get_userid() {
		return _userid;
	}

	public void set_userid(ObjectId _userid) {
		this._userid = _userid;
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
}
 
 
 
 