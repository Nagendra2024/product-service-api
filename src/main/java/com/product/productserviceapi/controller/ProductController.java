package com.product.productserviceapi.controller;

import com.product.productserviceapi.entity.Products;
import com.product.productserviceapi.repository.ProductRepository;
import com.product.productserviceapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        return ResponseEntity.of(productRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
