package com.fithnitek.UserManagement.service;

import java.util.List;
import java.util.Optional;

import com.fithnitek.UserManagement.model.Product;
public interface IProductService {
	public Product save(Product product);
	public List<Product> findAll();
	public void delete(String  email);
    public Optional<Product> getProductById(int  id);
	public Product updateProduct(int id , Product product);



}
