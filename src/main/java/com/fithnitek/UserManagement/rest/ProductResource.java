package com.fithnitek.UserManagement.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fithnitek.UserManagement.model.Product;
import com.fithnitek.UserManagement.service.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductResource {

	
	 private final Logger log =  LoggerFactory.getLogger(UserResource.class);
		private  final IProductService service;
	 
	 public ProductResource(IProductService service) {
			this.service = service;
		}

	@GetMapping("/")
	    public  List<Product> getAllProducts() {
	    log.debug("REST request to get all user");
	        return service.findAll();
	    }
}
