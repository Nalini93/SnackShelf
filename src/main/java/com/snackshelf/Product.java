package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Product{
    @Id
    public ObjectId _id;
    public String type, productName, companyName, productionDate, expirationDate;
    public SimpleDateFormat format;
    public double price;

    public Product(){}
    public Product(String type, String productionDate, String expirationDate, String productName, String companyName, double price){
        this.type = type;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
    }
    public String getProductId(){
        return _id.toHexString();
    }
    public void setProductId(ObjectId _productId){
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
    public String setProductionDate(){
        SimpleDateFormat format = new SimpleDateFormat("DD/MM/yyyy");
        Date date = new Date();
        System.out.println(format.format(date));
        return format.format(date);
    }
    public String getExpirationDate(){
        return this.expirationDate;
    }
    public String setExpirationDate(){
        SimpleDateFormat format = new SimpleDateFormat("DD/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date date = cal.getTime();
        System.out.println(format.format(date));
        return format.format(date);
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