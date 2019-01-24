package com.snackshelf;

import com.snackshelf.products.Product;
import com.snackshelf.products.ProductRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DebugClass{
    public static void main(String args[]) throws ParseException{
        /*String DATE_REGEX = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        String data = "28/02/2019";
        String data2 = "28/02/2019";

        if(data.matches(DATE_REGEX)){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
            System.out.println(date);
            System.out.println(date2);

            if(date.after(date2)){
                System.out.println("dopo");
            }else if(date.before(date2)){
                System.out.println("prima");
            }else{
                System.out.println("uguale");
            }
        }catch(ParseException e){
            e.printStackTrace();
        }*/
        ProductRepository repository = null;

    }
}