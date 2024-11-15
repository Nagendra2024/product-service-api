package com.product.productserviceapi.service;

import com.product.productserviceapi.entity.Products;
import com.product.productserviceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Products saveProduct(Products product) {
        return repository.save(product);
    }

    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return repository.findById(id);
    }

}
