package com.fithnitek.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fithnitek.UserManagement.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
