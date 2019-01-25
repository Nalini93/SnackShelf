package com.snackshelf.products;

import com.snackshelf.products.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDate{
    Date eDate, pDate;

    public ProductDate(Date pDate, Date eDate){
        this.pDate = pDate;
        this.eDate = eDate;
    }

    public boolean checkDate(){
        boolean check;

        if(this.eDate.after(this.pDate)){
            check = true;
        }else if(this.eDate.before(this.pDate)){
            check = false;
        }else{
            check = false;
        }

        return check;
    }

    public Date geteDate(){
        return eDate;
    }
    public void seteDate(Date eDate){
        this.eDate = eDate;
    }
    public Date getpDate(){
        return pDate;
    }
    public void setpDate(Date pDate){
        this.pDate = pDate;
    }

    @Override
    public String toString(){
        return "ProductDate{" +
                "eDate=" + eDate +
                ", pDate=" + pDate +
                '}';
    }
}