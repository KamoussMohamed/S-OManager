package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ProductManager {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public boolean deleteProdcutByName(String productName);
    public Product getProductById(Long Id);
    public List<Product> getAllProducts();
    public boolean deleteProductById(Long productId);
}

