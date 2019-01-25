package com.snackshelf;

import com.snackshelf.Product;
import com.snackshelf.ProductRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
  public class ProductController {
   @Autowired
   private ProductRepository repository;

   //get 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public List getAllProducts() {
	 return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Product getProductById(@PathVariable("id") ObjectId id) {
	  return repository.findBy_id(id);
	 }
	
	//PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyProductById(@PathVariable("id") ObjectId id, @Valid @RequestBody Product product) {
	   product.set_id(id);
	   repository.save(product);
	  }
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Product createProduct(@Valid @RequestBody Product product) {
	   product.set_id(ObjectId.get());
	   repository.save(product);
	   return product;
	  }
	
	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteProduct(@PathVariable ObjectId id) {
	   repository.delete(repository.findBy_id(id));
	  }


	
}
