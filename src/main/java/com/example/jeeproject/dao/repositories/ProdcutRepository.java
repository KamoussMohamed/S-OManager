package com.example.jeeproject.dao.repositories;

import com.example.jeeproject.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Product, Long> {
    public void deleteProductByProductName(String productName);
    public Product findByProductName(String productName);
    public Product findProductById(Long productId);
}
