package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Order;

import java.util.List;

public interface OrderManager {
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public Order getOrderById(Integer orderId);
    public List<Order> getAllOrders();
    public boolean deleteOrderByOrderId(Integer orderId);
    public double totalAmount(Integer orderId);
}
