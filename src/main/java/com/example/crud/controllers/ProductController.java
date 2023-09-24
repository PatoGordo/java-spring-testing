package com.example.crud.controllers;

import com.example.crud.domain.entities.Product;
import com.example.crud.dtos.RequestProduct;
import com.example.crud.repositories.ProductRepository;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RescaleOp;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getProducts() {
        var products = productRepository.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable String id) {
        var product = productRepository.findById(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity storeProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data.name(), data.price());

        productRepository.save(newProduct);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data) {
        Product product = productRepository.getReferenceById(id);

        product.setName(data.name());
        product.setPrice(data.price());

        productRepository.save(product);

        return ResponseEntity.ok(product.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        Product product = productRepository.getReferenceById(id);

        productRepository.delete(product);

        return  ResponseEntity.ok(product.getId());
    }
}
