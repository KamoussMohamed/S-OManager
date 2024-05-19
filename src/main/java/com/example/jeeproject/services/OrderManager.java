package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderManager {
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public Order getOrderById(Integer orderId);
    public List<Order> getAllOrders();
    @Transactional
    public boolean deleteOrderByOrderId(Integer orderId);
    public double totalAmount(Integer orderId);
    public String productsDisplay(Integer orderId);
}
