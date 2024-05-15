package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Product;
import com.example.jeeproject.dao.repositories.ProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService implements ProductManager {

    @Autowired
    private ProdcutRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public boolean deleteProdcutByName(String productName) {
        try{
            productRepository.deleteProductByProductName(productName);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteProductById(Long productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
