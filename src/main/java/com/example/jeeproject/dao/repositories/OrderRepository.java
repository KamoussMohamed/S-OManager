package com.example.jeeproject.dao.repositories;

import com.example.jeeproject.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    public Order findByOrderId(Integer orderId);
    public void deleteByOrderId(Integer orderId);
    public void deleteOrderByOrderId(Integer orderId);
}
