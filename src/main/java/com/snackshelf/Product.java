package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product{
    @Id
    public ObjectId _id;
    public String type, productName, companyName, productionDate, expirationDate;
    public double price;

    public String getId(){
        return _id.toHexString();
    }
    public void setId(ObjectId _id){
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
    public void setProductionDate(String productionDate){ this.productionDate = productionDate; }
    public String getExpirationDate(){
        return this.expirationDate;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate; }
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
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product[" +
                "_productId=" + _id +
                ", type='" + type + '\'' +
                ", productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productionDate=" + productionDate +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                ']';
    }
}