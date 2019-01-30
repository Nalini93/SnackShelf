package com.snackshelf;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{
    @Autowired
    private ProductRepository repository;
    /*@Autowired
    private OrderRepository repository1;*/
    private static final String DATE_REGEX = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
    private ProductDate productDate;

    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllProducts(){
        if(repository.findAll().isEmpty()){
            throw new ProductNotFoundException();
        }else{
            return repository.findAll();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") String id){
    	if(id.length()!=24) {
			throw new ProductNotFoundException();
		}else {
		if(repository.existsById(id)){
	  		return repository.findBy_id(new ObjectId(id));
	  		
		}else{
			throw new ProductNotFoundException();
		}
		}

    }

    //PUT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyProductById(@PathVariable("id") String id, @Valid @RequestBody Product product){
       
        if(id.length()!=24) {
			throw new ProductNotFoundException();
		}else {
			product.setId(new ObjectId(id));
        if(StringUtils.isEmpty(product.getType())||StringUtils.isEmpty(product.getCompanyName())||StringUtils.isEmpty(product.getProductName())||StringUtils.isEmpty(product.getProductionDate())||StringUtils.isEmpty(product.getExpirationDate())||StringUtils.isEmpty(Double.toString(product.getPrice())) ) {
 		   throw new OrderBadRequestException();
        }else {
        if(repository.existsById(id)){
            repository.save(product);
        }else{
            throw new ProductNotFoundException();
        }
        }
		}
    }

    //POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product) throws ProductNotFoundException{
        product.setId(ObjectId.get());
        if(StringUtils.isEmpty(product.getType())||StringUtils.isEmpty(product.getCompanyName())||StringUtils.isEmpty(product.getProductName())||StringUtils.isEmpty(product.getProductionDate())||StringUtils.isEmpty(product.getExpirationDate())||StringUtils.isEmpty(Double.toString(product.getPrice())) ) {
  		   throw new OrderBadRequestException();
         }else {
        repository.save(product);
         }
        return product;
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id){
    	 if(id.length()!=24) {
				throw new ProductNotFoundException();
		 }else {
				if(repository.existsById(id)){ 
		   	repository.delete(repository.findBy_id(new ObjectId(id)));
		   	
		   }else {
		  throw new ProductNotFoundException();
	  }
	}
    }

    //METHODS
    public void execute(Product product){
        if(product.getType() == null || product.getProductionDate() == null || product.getExpirationDate() == null || product.getProductName() == null || product.getCompanyName() == null || product.getPrice() <= 0){
            throw new ProductBadRequestException();
        }else if(!product.getExpirationDate().matches(DATE_REGEX) || !product.getProductionDate().matches(DATE_REGEX)){
            throw new ProductBadRequestException();
        }else{
            try{
                Date pDate = new SimpleDateFormat("dd/MM/yyyy").parse(product.getProductionDate());
                Date eDate = new SimpleDateFormat("dd/MM/yyyy").parse(product.getExpirationDate());
                productDate = new ProductDate(pDate, eDate);

                if(productDate.checkDate()){
                    repository.save(product);
                }else{
                    throw new ProductBadRequestException();
                }
            }catch(ParseException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

   /* public ArrayList<String> iterateProducts(ProductRepository repo){
        ArrayList<String> listID = new ArrayList<>();
        for(Product product : repo.findAll()){
            listID.add(product.getId());
        }
        return listID;
    }*/
}