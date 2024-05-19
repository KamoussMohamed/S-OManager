package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Order;
import com.example.jeeproject.dao.entities.Product;
import com.example.jeeproject.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service

public class OrderService implements OrderManager{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteOrderByOrderId(Integer orderId) {
        try {
            orderRepository.deleteOrderByOrderId(orderId);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public double totalAmount(Integer orderId){
        Order order = getOrderById(orderId);
        Map<Product, Integer> productOccurrences = new HashMap<>();

        for (Product product : order.getProducts()) {
            productOccurrences.put(product, productOccurrences.getOrDefault(product, 0) + 1);
        }

        double totalAmount = 0.0;
        for (Map.Entry<Product, Integer> entry : productOccurrences.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalAmount += product.getProductUnitPrice() * quantity;
        }
        return totalAmount;
    }

    @Override
    public String productsDisplay(Integer orderId) {
        Order order = getOrderById(orderId);
        Map<Product, Integer> productOccurrences = new HashMap<>();

        for (Product product : order.getProducts()) {
            productOccurrences.put(product, productOccurrences.getOrDefault(product, 0) + 1);
        }

        StringBuilder display = new StringBuilder();

        for (Map.Entry<Product, Integer> entry : productOccurrences.entrySet()) {
            Product product = entry.getKey();
            int occurrence = entry.getValue();
            String displayString = product.getProductName() + " x" + occurrence + "<br>"; // Add newline
            display.append(displayString);
        }

        return display.toString();
    }




}
