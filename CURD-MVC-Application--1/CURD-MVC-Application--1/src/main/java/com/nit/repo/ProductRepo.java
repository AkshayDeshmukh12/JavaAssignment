package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
