package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Product{
    @Id
    public ObjectId _productId;
    public String type, productName, companyName;
    public Date productionDate, expirationDate;
    public double price;

    public Product(){}
    public Product(ObjectId _productId, String type, Date productionDate, Date expirationDate, String productName, String companyName, double price){
        this._productId = _productId;
        this.type = type;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
    }
    public ObjectId getProductId(){
        return _productId;
    }
    public void setProductId(ObjectId _productId){
        this._productId = _productId;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public Date getProductionDate(){
        return this.productionDate;
    }
    public void setProductionDate(Date productionDate){
        this.productionDate = productionDate;
    }
    public Date getExpirationDate(){
        return this.expirationDate;
    }
    public void setExpirationDate(Date expirationDate){
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
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product{" +
                "_productId=" + _productId +
                ", type='" + type + '\'' +
                ", productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productionDate=" + productionDate +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                '}';
    }
}