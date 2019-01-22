/*package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Product{
    @Id
    public ObjectId _id;
    
    public String type, productionDate, expirationDate, productName, companyName;
    public double price;

    // Constructors
    public Product(){}
    public Product(ObjectId _id, String type, String productionDate, String expirationDate, String productName, String companyName, double price){
        this._id = _id;
        this.type = type;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
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
}*/