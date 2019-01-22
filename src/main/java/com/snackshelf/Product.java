package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Product{
    @Id
    public ObjectId _id;
    
    public String type, productionDate, expirationDate, productName, companyName;
    public double price;

    // Constructors
    public Product(){}
    public Product(String type, String productionDate, String expirationDate, String productName, String companyName, double price){
        
        this.type = type;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
    }
    
    public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getProductionDate(){
        return this.productionDate;
    }
    public void setProductionDate(String productionDate){
        this.productionDate = productionDate;
    }
    public String getExpirationDate(){
        return this.expirationDate;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }
	@Override
	public String toString() {
		return "Product [_id=" + _id + ", type=" + type + ", productionDate=" + productionDate + ", expirationDate="
				+ expirationDate + ", productName=" + productName + ", companyName=" + companyName + ", price=" + price
				+ "]";
	}
    
}